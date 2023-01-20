package me.xiaoz.dp;

public class Profit {

    public int maxProfit(int[] prices) {
        return maxProfit(2, prices);
    }

    int[][][] dp;

    public int maxProfit(int max_k, int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        dp = new int[prices.length][max_k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= max_k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][max_k][0];
    }


    public static void main(String[] args) {
        new Profit().getSum(13, 11);
    }

    public int getSum(int a, int b) {
        if (a == 0) return b;
        int carry = (a & b) << 1;
        int sum = a ^ b;
        System.out.println("carry: " + carry + " " + Integer.toBinaryString(carry) + ", sum: " + sum + " " + Integer.toBinaryString(sum));
        return getSum(carry, sum);
    }


}
