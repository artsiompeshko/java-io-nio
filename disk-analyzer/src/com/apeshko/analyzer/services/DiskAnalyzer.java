package com.apeshko.analyzer.services;

import com.apeshko.analyzer.model.FirstLetterSplitEntry;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public interface DiskAnalyzer {
    Path getFilePathWitMaxValue(Path dir, Comparator<Path> comparator) throws IllegalArgumentException, IOException;
    Path getFilePathWithLongestName(Path dir) throws IllegalArgumentException, IOException;
    List<Path> getTopFiles(Path dir, int limit, Comparator<Path> comparator) throws IOException;
    List<Path> getTopFilesBySize(Path dir, int limit) throws IOException;
    double getAverageFileSize(Path dir) throws IOException;
    List<FirstLetterSplitEntry> splitByFirstLetter(Path dir) throws IOException;
}
