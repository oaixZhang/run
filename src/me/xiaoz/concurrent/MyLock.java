package me.xiaoz.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class MyLock {
    volatile int state;
    Node head;
    Node tail;
    static Unsafe unsafe;
    static long stateOffset;
    static long tailOffset;


    public MyLock() {
        head = new Node();
        tail = head;
    }

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state"));
            tailOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("tail"));

        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void lock() {
        if (compareAndSetState(0, 1)) {
            return;
        }
        Node node = enqueue();
        Node pre = node.pre;
        while (pre != head || !compareAndSetState(0, 1)) {
            unsafe.park(false, 0);
        }
        // 下面不需要原子更新，因为同时只有一个线程访问到这里
        // 获取到锁了且上一个节点是head
        // head后移一位
        head = node;
        node.thread = null;
        node.pre = null;
        pre.next = null;
    }

    public void unlock() {
        state = 0;
        if (head.next != null) {
            unsafe.unpark(head.next.thread);
        }
    }


    private Node enqueue() {
        while (true) {
            Node t = tail;
            Node node = new Node(Thread.currentThread(), t);
            if (compareAndSetTail(t, node)) {
                t.next = node;
                return node;
            }
        }
    }

    private boolean compareAndSetState(int old, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, old, update);
    }

    public boolean compareAndSetTail(Node old, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, old, update);
    }


    public static class Node {
        Thread thread;
        private volatile Node pre;
        private volatile Node next;
        static Unsafe unsafe;

        public Node(Thread thread, Node pre) {
            this.thread = thread;
            this.pre = pre;
        }

        public Node() {
        }
    }


    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
//        MyLock mLock = new MyLock();
        MyAQS mLock = new MyAQS();
        CountDownLatch latch = new CountDownLatch(1000);

        IntStream.range(0, 1000).forEach(value -> {
            new Thread(() -> {
                mLock.acquire(1);
                System.out.println("thread " + value + " get lock.");

                IntStream.range(0, 10000).forEach(i -> {
                    count++;
                });

                mLock.release(1);
                latch.countDown();
            }, "t" + value).start();
        });

        latch.await();

        System.out.println("done: " + count);

    }

}
