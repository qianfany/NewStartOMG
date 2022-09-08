public class L121BestTimeToBuySellStock {
    /*
            7   1   5   3   6   4
            max = 0
            min = 1
     min    7   1   1   1   1   1
     max    0   0   4   2   5   3
     for each step, check min = min(min, prices[i])
                    check max = max(max, prices[i] - min)

     Time:  O(n)
     Space: O(1)
     */
    // * * *
    public int maxProfit (int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public int maxProfit1 (int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (soFarMin > prices[i]) {
                soFarMin = prices[i];
            } else {
                max = Math.max(max, prices[i] - soFarMin);
            }
        }
        return max;
    }
}
