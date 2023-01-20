package me.xiaoz.classic;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        int[] greater = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= num)
                stack.pop();
            greater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greater[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
