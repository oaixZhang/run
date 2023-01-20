package me.xiaoz.dp;

import java.util.Stack;

public class Trap {
    public int trap1(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int length = height.length;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        for (int i = 0; i < length; i++) {
            leftMax = 0;
            rightMax = 0;
            int current = height[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int min = Math.min(leftMax, rightMax);
            if (current < min) {
                res += min - current;
            }
        }
        return res;
    }

    int[] left, right;

    public int trap2(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int length = height.length;
        left = new int[length];
        right = new int[length];
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0)
                left[i] = height[i];
            else
                left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1)
                right[i] = height[i];
            else
                right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < length; i++) {
            int current = height[i];
            int min = Math.min(left[i], right[i]);
            if (current < min) {
                res += min - current;
            }
        }
        return res;
    }

    public int trap3(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int length = height.length;
        int left = 0, right = length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                res += distance * (Math.min(height[stack.peek()], height[i]) - height[top]);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
