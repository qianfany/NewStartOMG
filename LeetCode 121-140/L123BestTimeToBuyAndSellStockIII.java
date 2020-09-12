public class L123BestTimeToBuyAndSellStockIII {
    /**
     * dynamic Programming
     * dp[i] = max(dp[i - 1], prices[i] - prices[j] + dp[j - 2])
     * j = [0... i -1]
     *
     *      3   3   5   0   0   3   1   4
     *  0   0   0   2   2
     *      min = 0
     * @param prices
     * @return
     */
    public int maxProfit (int[] prices) {
        if (prices.length < 2) return 0;
        int prev = 0, res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i] - prev);
            prev = res;
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
    /**
     *
     *  bidirectional
     *  O(N) time
     *
     */
    public int maxProfitDp (int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;

        int leftMin = prices[0];
        int rightMax = prices[length - 1];

        int[] leftProfits = new int[length];
        // pad the right DP array with an additional zero for convenience.
        int[] rightProfits = new int[length + 1];

        // construct the bidirectional DP array
        for (int l = 1; l < length; ++l) {
            leftProfits[l] = Math.max(leftProfits[l - 1], prices[l] - leftMin);
            leftMin = Math.min(leftMin, prices[l]);

            int r = length - 1 - l;
            rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }

        int maxProfit = 0;
        for (int i = 0; i < length; ++i) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        }
        return maxProfit;
    }
}
