package me.xiaoz.array;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int num : nums) {
            queue.offer(num);
            while (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new KLargest().findKthLargest(IntStream.range(0, 10).toArray(), 3));
    }
}
