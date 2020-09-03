public class C12BuyStockII {
    /*
    buy or sell one unit per day
    Dynamic Programming
    {2, 3, 2, 1, 4, 5}
    3 - 2 + 5 - 1 = 5
    Time: O(n)
    Space: O(1)

     */
    public int maxProfit (int[] array) {
        int profit = 0;
        for (int i = 1; i < array.length; i++) {
            profit += Math.max(0, array[i] - array[i - 1]);
        }
        return profit;
    }
}
