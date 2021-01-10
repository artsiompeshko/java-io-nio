package com.apeshko.fastfilemover.services.impl;

import com.apeshko.fastfilemover.services.Profiler;

public class TimeIt implements Profiler {
    @Override
    public long measure(Runnable task) {
        long now = System.currentTimeMillis();

        task.run();

        return System.currentTimeMillis() - now;
    }
}
