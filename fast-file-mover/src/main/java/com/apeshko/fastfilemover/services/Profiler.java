package com.apeshko.fastfilemover.services;

public interface Profiler {
    long measure(Runnable task);
}
