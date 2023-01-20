package me.xiaoz.dp;

import java.util.Arrays;

public class CoinChange {

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (memo[amount] != -666)
            return memo[amount];
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            int sub = dp(coins, amount - coins[i]);
            if (sub == -1)
                continue;
            temp = Math.min(sub + 1, temp);
        }
        memo[amount] = temp == Integer.MAX_VALUE ? -1 : temp;
        return memo[amount];
    }

    int[] dp;

    public int coinChangedp(int[] coins, int amount) {
        dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (dp[i - coin] < 0)
                    continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
