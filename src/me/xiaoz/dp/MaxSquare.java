package me.xiaoz.dp;

public class MaxSquare {
    int[][] dp;

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        dp = new int[row][column];
        int maxSide = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        continue;
                    }
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }

}
