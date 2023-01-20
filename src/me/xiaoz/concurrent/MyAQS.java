package me.xiaoz.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAQS extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return compareAndSetState(0,1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return compareAndSetState(1,0);
    }
}
