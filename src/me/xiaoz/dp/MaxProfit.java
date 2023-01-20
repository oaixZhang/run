package me.xiaoz.dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
