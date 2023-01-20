package me.xiaoz.classic;

import java.util.*;

public class MaxSlidingWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> record = new ArrayList<>();
        Deque<Integer> window = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (!window.isEmpty() && window.peek() == nums[i - k])
                    window.remove();
            }

            while (!window.isEmpty() && window.getLast() < nums[i]) {
                window.removeLast();
            }
            window.offer(nums[i]);
            if (i >= k - 1) {
                record.add(window.peek());
            }
        }

        int[] res = new int[record.size()];
        for (int i = 0; i < record.size(); i++) {
            res[i] = record.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
