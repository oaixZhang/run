package me.xiaoz.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAlternately {
    public static int count;
    public static volatile int volatileCount;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);

//        for (int i = 0; i < 2; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    lock.lock();
//                    while (count < 50) {
//                        System.out.println(Thread.currentThread().getName() + " print " + ++count);
//                    }
//                    lock.unlock();
//                }
//            }, "thread_" + i).start();
//        }

        AtomicInteger occupied = new AtomicInteger(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (volatileCount < 50) {
                    while (occupied.compareAndSet(0, 1)) {
                        System.out.println(Thread.currentThread().getName() + " print " + ++volatileCount);
                    }
                    occupied.compareAndSet(1, 2);
                }
            }
        }, "thread_1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (volatileCount < 50) {
                    while (occupied.compareAndSet(2, 3)) {
                        System.out.println(Thread.currentThread().getName() + " print " + ++volatileCount);
                    }
                    occupied.compareAndSet(3, 0);
                }
            }
        }, "thread_2").start();

    }
}
