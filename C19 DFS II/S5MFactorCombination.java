import java.util.ArrayList;
import java.util.List;

public class S5MFactorCombination {
    /*
    Print all valid combination of factors that form an integer
    step 1: preprocessing: find all factors of target   (6, 4, 3, 2)
    12 = 6 2
       = 4 3
       = 3 2 2
    step 2:
    how many levels in the recursion tree? what does it store on each level
    1 level for each factor
    how many different states should we try to put on each level
                                12
                             /          \
     6                   0 (6)         1 (6)
                       /       \        /
     4               0 (4)      1(4)     0(4)
                   /      \     /   \   /     \
                 0(3)    1(3)       1(3)

    Time: O(  (Number of Factors) ^ (log n) )
     */
    public List<List<Integer>> combinationsBetter (int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 1) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper (target, factors, 0, cur, result);
        return result;
    }

    private void helper (int target, List<Integer> factors, int index, List<Integer> cur,
                         List<List<Integer>> result) {
        if (index == factors.size()) {
            if (target == 1) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        helper(target, factors, index + 1, cur, result);
        int factor = factors.get(index);
        int size = cur.size();
        while (target % factor == 0) {
            cur.add(factor);
            target /= factor;
            helper(target, factors, index + 1, cur, result);
        }
        cur.subList(size, cur.size()).clear();
    }


    private List<Integer> getFactors (int target) {
        List<Integer> factors = new ArrayList<>();
        for (int i = target /2; i > 1; i--) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    /*
                        Naive solution:
                            12
                          / |||||\\\\\\
                        2 (6)
                      /||||
                     2(3)
                    /|
                   2 3(1)

                   Time: O( n ^ log n)

     */


    public List<List<Integer>> combinations (int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper (target, 2, res, cur);
        return res;
    }

    private void helper (int target, int index, List<List<Integer>> res, List<Integer> cur) {
        if (target == 1) {
            if (cur.size() > 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = index; i <= target; i++) {
            if (target % i == 0) {
                cur.add(i);
                helper(target /i, i, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
