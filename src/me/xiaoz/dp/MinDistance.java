package me.xiaoz.dp;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i][j - 1] + 1,
                            Math.min(dp[i - 1][j - 1] + 1,
                                    dp[i - 1][j] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("intention", "execution"));
    }
}
