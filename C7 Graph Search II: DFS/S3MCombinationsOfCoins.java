import java.util.ArrayList;
import java.util.List;

public class S3MCombinationsOfCoins {
    /*
    Assumption: numbers are sorted in descending order
    Level: 4
    Branches: dynamic changing
    Time: O(99 ^ 4)
    Space: O(4)

                                        (99)
                                /    /     |     \
                               0    25     50     75
                            /||||\
                          0 10 20 30
                        /|||||
                       0 5 10 15
                     /||||||
                   0 1 2 3 4
     */
    public List<List<Integer>> combination (int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper (target, coins, 0, cur, result);
        return result;
    }

    private void helper (int target, int[] coins, int index, List<Integer> cur,
                         List<List<Integer>> result) {
        if (index == coins.length - 1) {
            // money on the last level
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
