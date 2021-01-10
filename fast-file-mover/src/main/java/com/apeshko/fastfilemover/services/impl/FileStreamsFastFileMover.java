package com.apeshko.fastfilemover.services.impl;

import com.apeshko.fastfilemover.services.FastFileMover;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStreamsFastFileMover implements FastFileMover {
    @Override
    public void move(String filePath, String nextFilePath) throws IOException {
        File source = new File(filePath);
        File dest = new File(nextFilePath);

        try (FileInputStream fileInputStream = new FileInputStream(source);
             FileOutputStream fileOutputStream = new FileOutputStream(dest)) {

            int data;
            while((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
        }
    }
}
