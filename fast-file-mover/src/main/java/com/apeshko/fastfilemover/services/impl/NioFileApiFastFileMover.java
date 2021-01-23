package com.apeshko.fastfilemover.services.impl;

import com.apeshko.fastfilemover.services.FastFileMover;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class NioFileApiFastFileMover implements FastFileMover {
    @Override
    public void move(String filePath, String nextFilePath) throws IOException {
        File source = new File(filePath);
        File dest = new File(nextFilePath);

        Files.copy(source.toPath(), dest.toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    }
}
