import java.util.ArrayList;
import java.util.List;

public class L77Combinations {
    /*
                            {}
                        /          \
                      {a}           {}                              for a
                   /      \       /      \
                {a, b}    {a}    {b}      {}                        for b
               /   \     /   \   /   \    /  \
            abc    ab   ac    a  bc   b   c   {}                    for c

            add or not add
            level:      n
            branches:   2
            Time: O(2 ^ n)
            Space: O(n)
        just like all subsets of size k
        recursion tree has n levels, and it is a binary tree, (add or not add on each level)
        we can return as a base case when the size of the prefix-solution size == k

     */
    public List<List<Integer>> combine (int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i-1] = i;
        }
        helper (array, k, 0, list, res);
        return res;
    }

    private void helper (int[] array, int k,  int index,
                         List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == array.length) {
            return;
        }
        helper(array, k, index + 1, list, res);
        list.add(array[index]);
        helper(array, k, index + 1, list, res);
        list.remove(list.size() - 1);
    }
}
