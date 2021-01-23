package com.apeshko.fastfilemover.services;

import com.apeshko.fastfilemover.model.PerfTestArgs;

import java.io.IOException;

public interface FastFileMoverPerfTest {
    long measure(FastFileMover fastFileMover, PerfTestArgs perfTestArgs) throws IOException;
}
