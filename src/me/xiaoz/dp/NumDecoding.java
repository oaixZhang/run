package me.xiaoz.dp;

public class NumDecoding {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            char cur = s.charAt(i - 1);
            char last = s.charAt(i - 2);
            if (cur >= '1' && cur <= '9')
                dp[i] += dp[i - 1];
            if (last == '1' || last == '2' && cur <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecoding().numDecodings("11"));
    }
}
