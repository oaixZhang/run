package me.xiaoz.concurrent;

public class SynTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 1; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (SynTest.class) {
                        System.out.println("thread " + finalI);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        System.out.println("Main thread start");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1 start");
                try {
                    Thread.sleep(4000);
                } catch (Exception ignored) {

                }
                System.out.println("thread 1 end");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            System.out.println("thread 2 start");
            try {
                Thread.sleep(2000);
            } catch (Exception ignored) {

            }
            System.out.println("thread 2 end");
        });
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Main thread end");
    }
}
