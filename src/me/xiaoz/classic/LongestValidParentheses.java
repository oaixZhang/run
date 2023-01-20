package me.xiaoz.classic;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        if (s == null || s.length() < 2) return res;
        int[] dp = new int[s.length() + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < dp.length; i++) {
            char c = s.charAt(i - 1);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int pre = stack.pop();
                    int length = i - pre + 1;
                    dp[i] = dp[pre - 1] + length;
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
    }
}
