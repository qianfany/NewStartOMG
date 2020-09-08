import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.*;

public class L39CombinationSum {
    /*
    Assumption: numbers are sorted in descending order
    Level: n
    Branches: dynamic changing
    Time: O(n ^ target)
    Space: O(target)

                                        (99)
                                /    /     |     \
                                1   5      10       25
                             / | |
                            1  5 10
                           /
                          1
                         /
                        1
     */

    public List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper (list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void helper (List<List<Integer>> list, List<Integer> temp, int[] candidates,
                         int remain, int start) {
        if (remain < 0) {
            return;
        }
        else if (remain == 0) {
            list.add(new ArrayList<>(temp));
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                helper(list, temp, candidates, remain - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main (String[] args) {
        L39CombinationSum sol = new L39CombinationSum();
        int[] candidates = {2, 3, 5};
        System.out.println(sol.combinationSum(candidates, 8));
    }

}
