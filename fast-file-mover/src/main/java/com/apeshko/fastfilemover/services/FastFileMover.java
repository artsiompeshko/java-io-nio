package com.apeshko.fastfilemover.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FastFileMover {
    void move(String filePath, String nextFilePath) throws IOException;
}
