package me.xiaoz.dp;

public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        int res = dp[nums.length];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        res = Math.max(res, dp[nums.length - 1]);
        return res;
    }

    private static String uuid;

    public static void main(String[] args) {
        System.out.println( "uuids: " + uuid);
    }
}
