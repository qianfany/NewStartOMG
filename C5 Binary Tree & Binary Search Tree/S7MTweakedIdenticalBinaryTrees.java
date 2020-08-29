public class S7MTweakedIdenticalBinaryTrees {
    /*
                                     8
                                   /    \
                                  4      5
                                 /
                                 7
            8a      AND    8b       OR      8a      AND    8b
           /   \          /  \             /  \           /  \
          4a    5a      4b    5b          4a   5a        5b   4b
          /             /                 /                    \
          7             7                7                      7

          recursion Quadral tree
         Time:  4 ^ (log_2(2)) = O(n^2)
     */
    public boolean isTweakedIdentical (TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        if (one == null || two == null) {
            return false;
        }
        if (one.key != two.key) {
            return false;
        }
        return (isTweakedIdentical(one.left, two.left)
                && isTweakedIdentical(one.right, two.right))
                || (isTweakedIdentical(one.left, two.right)
                && isTweakedIdentical(one.right, two.left));
    }
}
