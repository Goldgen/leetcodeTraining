public class Solution_for_coin_change {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int dp[] = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int index = 1; index < dp.length; index++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= index&&dp[index - coins[i]] != Integer.MAX_VALUE)
                    dp[index] = Math.min(dp[index - coins[i]] + 1, dp[index]);

            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }
}
