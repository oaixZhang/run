package me.xiaoz.concurrent;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread currentThread = Thread.currentThread();
                    System.out.println(currentThread.getName());
                    System.out.println(currentThread.isInterrupted());
//                    e.printStackTrace();
                }
            }
        },"t-test");
        thread.start();
        thread.interrupt();
    }
}
