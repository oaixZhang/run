package me.xiaoz.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch main = new CountDownLatch(1);
        CountDownLatch sub = new CountDownLatch(4);

        System.out.println("main start");

        for (int i = 1; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    main.await();
                    System.out.printf("thread %d start\n", finalI);
                    Thread.sleep(finalI *1000);
                    System.out.printf("thread %d end\n", finalI);
                    sub.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("main thread do something...");
        Thread.sleep(2000);
        System.out.println("main thread prepared.");
        main.countDown();

        sub.await();
        System.out.println("sub task finished,main done.");
    }
}
