public class CoinCombination {

    public int CoinCombination (int num) {
        int[] coins = {11, 9, 7, 5, 1};
        return minNum(coins, num);

    }

    private int minNum (int[] coins, int num) {
        if (num == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= num) {
                int remain = minNum(coins, num - coins[i]);

                result = Math.min(result, remain + 1);
            }
        }
        return result;
    }

    public static void main (String[] args) {
        CoinCombination sol = new CoinCombination();
        System.out.println(sol.CoinCombination(6));
        System.out.println(sol.CoinCombination(16));
    }

}
