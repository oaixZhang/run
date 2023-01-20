package me.xiaoz.dp;

public class StringMinDistance {
    int[][] dp;

    //删掉 最长公共子序列 外的其他部分
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return 0;
        int m = word1.length();
        int n = word2.length();
        dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - dp[m][n] * 2;
    }

    public static void main(String[] args) {
        System.out.println(new StringMinDistance().minDistance("sea", "eat"));
    }
}
