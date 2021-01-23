package com.apeshko.analyzer.services.impl;

import com.apeshko.analyzer.model.FirstLetterSplitEntry;
import com.apeshko.analyzer.services.DiskAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiskAnalyzerImpl implements DiskAnalyzer {
    private void validateDirectoryPath(Path dir) {
        if (!Files.exists(dir)) {
            throw new IllegalArgumentException("Wrong dir " + dir + " provided");
        }

        if (!Files.isDirectory(dir)) {
            throw new IllegalArgumentException("Provided dir " + dir + " is not directory");
        }
    }

    @Override
    public Path getFilePathWitMaxValue(Path dir, Comparator<Path> comparator) throws IllegalArgumentException, IOException {
        this.validateDirectoryPath(dir);

        try (Stream<Path> paths = Files.walk(dir)) {
            return paths
                    .filter(path -> Files.isRegularFile(path))
                    .max(comparator)
                    .get();
        }
    }

    public List<Path> getTopFiles(Path dir, int limit, Comparator<Path> comparator) throws IOException {
        this.validateDirectoryPath(dir);

        try (Stream<Path> paths = Files.walk(dir)) {
            return paths
                    .filter(path -> Files.isRegularFile(path))
                    .sorted(comparator)
                    .limit(limit)
                    .collect(Collectors.toList());
        }
    }


    @Override
    public Path getFilePathWithLongestName(Path dir) throws IllegalArgumentException, IOException {
        return this.getFilePathWitMaxValue(dir, (o1, o2) -> Integer.compare(o1.getFileName().toString().length(), o2.getFileName().toString().length()));
    }

    @Override
    public List<Path> getTopFilesBySize(Path dir, int limit) throws IOException {
        return this.getTopFiles(dir, limit, (p1, p2) -> {
            try {
                return Long.compare(Files.size(p2), Files.size(p1));
            } catch (IOException exception) {
                exception.printStackTrace();

                return 0;
            }
        });
    }

    public double getAverage(Path dir, ToDoubleFunction<Path> toDoubleFunction) throws IOException {
        this.validateDirectoryPath(dir);

        try (Stream<Path> paths = Files.walk(dir)) {
            return paths
                    .filter(path -> Files.isRegularFile(path))
                    .mapToDouble(toDoubleFunction)
                    .average()
                    .orElse(Double.NaN);
        }
    }

    @Override
    public double getAverageFileSize(Path dir) throws IOException {
        return this.getAverage(dir, path -> {
            try {
                return Files.size(path);
            } catch (IOException exception) {
                exception.printStackTrace();

                return 0;
            }
        });
    }

    @Override
    public List<FirstLetterSplitEntry> splitByFirstLetter(Path dir) throws IOException {
        this.validateDirectoryPath(dir);

        Map<String, FirstLetterSplitEntry> firstLetters = new HashMap<>();

        try (Stream<Path> paths = Files.walk(dir)) {
            paths
                    .forEach(path -> {
                        Boolean isFile = Files.isRegularFile(path);
                        long filesCount = isFile ? 1 : 0;
                        long dirCount = 1 - filesCount;
                        String letter = path.getFileName().toString().substring(0, 1);

                        if (firstLetters.containsKey(letter)) {
                            FirstLetterSplitEntry firstLetterSplitEntry = firstLetters.get(letter);

                            firstLetterSplitEntry.addFilesCount(filesCount);
                            firstLetterSplitEntry.addDirCount(dirCount);
                        } else {
                            FirstLetterSplitEntry firstLetterSplitEntry = new FirstLetterSplitEntry(letter, filesCount, dirCount);

                            firstLetters.put(letter, firstLetterSplitEntry);
                        }
                    });
        }

        return firstLetters.values().stream()
                .sorted((o1, o2) -> o1.getLetter().compareTo(o2.getLetter()))
                .collect(Collectors.toList());
    }
}
