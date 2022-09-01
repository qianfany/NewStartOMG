import java.util.Arrays;

public class L1475FinalPricesWithSpecialDiscountShop {

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            res[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L1475FinalPricesWithSpecialDiscountShop sol = new L1475FinalPricesWithSpecialDiscountShop();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(sol.finalPrices(prices)));
    }
}
