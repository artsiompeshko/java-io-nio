package com.apeshko.analyzer;

import com.apeshko.analyzer.services.DiskAnalyzer;
import com.apeshko.analyzer.services.impl.DiskAnalyzerImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiskAnalyzerApp {
    public static void main(String[] args) throws IOException {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzerImpl();

        // TODO: validate args
        Path dir = Paths.get(args[0]);
        int limit = Integer.parseInt(args[1]);

        System.out.println(diskAnalyzer.getFilePathWithLongestName(dir).toString());
        System.out.println(diskAnalyzer.getTopFilesBySize(dir, limit).toString());
        System.out.println(diskAnalyzer.getAverageFileSize(dir));
        System.out.println(diskAnalyzer.splitByFirstLetter(dir));
    }
}
