package com.apeshko.fastfilemover.services.impl;

import com.apeshko.fastfilemover.services.FastFileMover;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelFastFileMover implements FastFileMover {

    @Override
    public void move(String filePath, String nextFilePath) throws IOException {
        RandomAccessFile source = new RandomAccessFile(filePath, "r");
        RandomAccessFile dest = new RandomAccessFile(nextFilePath, "rw");

        try (FileChannel sfc = source.getChannel();
             FileChannel dfc = dest.getChannel()) {

            dfc.transferFrom(sfc, 0, sfc.size());
        }
    }
}
