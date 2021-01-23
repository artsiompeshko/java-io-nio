package com.apeshko.fastfilemover.services.impl;

import com.apeshko.fastfilemover.model.PerfTestArgs;
import com.apeshko.fastfilemover.services.FastFileMover;
import com.apeshko.fastfilemover.services.FastFileMoverPerfTest;

import java.io.IOException;

public class FastFileMoverPerfTestImpl implements FastFileMoverPerfTest {
    TimeIt timeIt = new TimeIt();

    @Override
    public long measure(FastFileMover fastFileMover, PerfTestArgs perfTestArgs) {
        Long ms = timeIt.measure(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    fastFileMover.move(perfTestArgs.getSmFilePath(), perfTestArgs.getSmFilePath() + "perf");
                    fastFileMover.move(perfTestArgs.getMdFilePath(), perfTestArgs.getMdFilePath() + "perf");
                    fastFileMover.move(perfTestArgs.getLgFilePath(), perfTestArgs.getLgFilePath() + "perf");
                    fastFileMover.move(perfTestArgs.getXlgFilePath(), perfTestArgs.getXlgFilePath() + "perf");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });

        return ms;
    }
}
