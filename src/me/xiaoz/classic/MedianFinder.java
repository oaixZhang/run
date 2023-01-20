package me.xiaoz.classic;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        largeHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smallHeap.size() > largeHeap.size()) {
            smallHeap.offer(num);
            largeHeap.offer(smallHeap.poll());
        } else {
            largeHeap.offer(num);
            smallHeap.offer(largeHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() > largeHeap.size())
            return smallHeap.peek();
        else if (smallHeap.size() < largeHeap.size())
            return largeHeap.peek();
        else
            return (largeHeap.peek() + smallHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }
}