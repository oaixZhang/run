package me.xiaoz.dp;

import java.util.Arrays;

public class longestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    int[][] mem;

    public int longestCommonSubsequencedp(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        mem = new int[m][n];
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }

        return dp(s1, m - 1, s2, n - 1);
    }

    private int dp(String s1, int m, String s2, int n) {
        if (m < 0 || n < 0)
            return 0;
        if (mem[m][n] != -1)
            return mem[m][n];
        if (s1.charAt(m) == s2.charAt(n)) {
            mem[m][n] = dp(s1, m - 1, s2, n - 1) + 1;
        } else {
            mem[m][n] = Math.max(dp(s1, m - 1, s2, n), dp(s1, m, s2, n - 1));
        }
        return mem[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new longestCommonSubsequence().longestCommonSubsequence("abcde", "plm"));
    }

}
