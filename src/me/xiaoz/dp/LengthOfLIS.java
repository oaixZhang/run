package me.xiaoz.dp;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i : dp) {
            if (i > res) res = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
}
