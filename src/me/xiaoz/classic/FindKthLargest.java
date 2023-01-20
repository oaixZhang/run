package me.xiaoz.classic;

import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
