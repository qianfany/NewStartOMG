public class L122BestTimeToBuyAndSellStockII {
    /**
     * buy and sell multiple times
     * repeatedly buy and sell if prices[i] - prices[i -1]
     *
     */
    public int maxProfit (int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
