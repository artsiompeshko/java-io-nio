package com.apeshko.fastfilemover.services.impl;

import com.apeshko.fastfilemover.services.FastFileMover;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedFileStreamsFastFileMover implements FastFileMover {
    @Override
    public void move(String filePath, String nextFilePath) throws IOException {
        File source = new File(filePath);
        File dest = new File(nextFilePath);

        try (FileInputStream fileInputStream = new FileInputStream(source);
             FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
            // 100kb buffer
            byte[] buffer = new byte[1000 * 100];

            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
        }
    }
}
