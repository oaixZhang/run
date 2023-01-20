package me.xiaoz.dp;

public class UniquePathsWithObstacles {
    int[][] memo;

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        memo = new int[row][column];
        return dp(row - 1, column - 1, obstacleGrid);
    }

    private int dp(int m, int n, int[][] obstacleGrid) {
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0)
            return 1;
        if (memo[m][n] != 0)
            return memo[m][n];
        memo[m][n] = dp(m - 1, n, obstacleGrid) + dp(m, n - 1, obstacleGrid);
        return memo[m][n];
    }

    int[] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        dp = new int[column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (i == 1 && j == 1) {
                    dp[j] = obstacleGrid[i - 1][j - 1] == 0 ? 1 : 0;
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1)
                    dp[j] = 0;
                else
                    dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[column];
    }

}
