package me.xiaoz.dp;

import java.util.Arrays;

public class MinDeleteSum {
    int[][] mem;

    public int minimumDeleteSum(String word1, String word2) {
        if (word1 == null || word2 == null)
            return 0;
        int m = word1.length();
        int n = word2.length();
        mem = new int[m][n];
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        return dp(word1, m - 1, word2, n - 1);
    }

    private int dp(String word1, int m, String word2, int n) {
        if (m < 0 && n < 0)
            return 0;
        if (m < 0)
            return sumLeft(word2, n);
        if (n < 0)
            return sumLeft(word1, m);
        if (mem[m][n] != -1) {
            return mem[m][n];
        }
        if (word1.charAt(m) == word2.charAt(n)) {
            mem[m][n] = dp(word1, m - 1, word2, n - 1);
        } else {
            mem[m][n] = Math.min(dp(word1, m - 1, word2, n) + word1.charAt(m),
                    dp(word1, m, word2, n - 1) + word2.charAt(n));
        }
        return mem[m][n];
    }

    private int sumLeft(String word2, int n) {
        int res = 0;
        while (n >= 0)
            res += word2.charAt(n--);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinDeleteSum().minimumDeleteSum("sea", ""));
    }
}
