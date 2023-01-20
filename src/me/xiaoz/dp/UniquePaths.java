package me.xiaoz.dp;

import java.util.Arrays;

public class UniquePaths {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return uniquePathsBp(m - 1, n - 1);
    }

    private int uniquePathsBp(int m, int n) {
        if (m == 0 && n == 0)
            return 1;
        if (memo[m][n] != 0)
            return memo[m][n];
        if (m == 0) {
            memo[m][n] = uniquePathsBp(m, n - 1);
        } else if (n == 0) {
            memo[m][n] = uniquePathsBp(m - 1, n);
        } else {
            memo[m][n] = uniquePathsBp(m - 1, n) + uniquePathsBp(m, n - 1);
        }
        return memo[m][n];
    }

    int[][] dp;

    public int uniquePaths2(int m, int n) {
        dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < dp.length; i++) {
            int[] ints = dp[i];
            for (int j = 0; j < ints.length; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
