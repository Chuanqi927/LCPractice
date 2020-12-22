package Leetcode;

import java.util.Arrays;

public class LC322_CoinChange {
    class Solution{
//        greedy will not work because due to the value of coins
//        bottom up DP approach:
//        dp[i] means the minimal count needed to satisfy amount=i
        public int coinChange(int[] coins, int amount) {
            int max = amount+1;
            int[] dp = new int[max];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return (dp[amount] > amount) ? -1 : dp[amount];

        }
    }
}
