public class L121BestTimeToBuySellStock {
    /*
            7   1   5   3   6   4
            max = 0
            min = 1
     for each step, check min = min(min, prices[i])
                    check max = max(max, prices[i] - min)

     Time:  O(n)
     Space: O(1)
     */
    public int maxProfit (int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
