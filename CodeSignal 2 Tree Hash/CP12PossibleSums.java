import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CP12PossibleSums {
    /**
     *                         0
     *                      /    \
     * 10                  0       1
     *                   / / \    / \ \
     * 50               0  1  2   0  1 2
     *                / \
     * 100           0  1
     *
     * @param coins
     * @param quantity
     * @return
     */
    public int possibleSums (int[] coins, int[] quantity) {
        Set<Integer> set = new HashSet<>();
        int counter = 0;
        List<List<Integer>> res = possibleWays(quantity);
        for (List<Integer> list : res) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum = sum + list.get(i) * coins[i];
            }
            if (set.add(sum)) {
                counter++;
            }
        }
        return counter - 1;
    }

    public List<List<Integer>> possibleWays (int[] quantity) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper (quantity, 0, list, res);
        return res;
    }

    private void helper (int[] quantity, int index, List<Integer> list,
                         List<List<Integer>> res) {
        if (index == quantity.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <= quantity[index]; i++) {
            list.add(i);
            helper (quantity, index + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main (String[] args) {
        CP12PossibleSums sol = new CP12PossibleSums();
        int[] coins = {10, 50, 100};
        int[] quantity = {1, 2, 1};
        System.out.println(sol.possibleSums(coins, quantity));
    }


}
