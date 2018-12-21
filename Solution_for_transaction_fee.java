public class Solution_for_transaction_fee {
    public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        int[] hold = new int[l + 1];
        int[] notHold = new int[l + 1];
        hold[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= l; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i - 1] - fee);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i - 1]);
        }

        return notHold[l];
    }
}
