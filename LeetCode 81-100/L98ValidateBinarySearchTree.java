public class L98ValidateBinarySearchTree {
    /**
                    10 (-inf, +inf)
                  /                    \
               5(-inf,10)               15(10, +inf)
            /           \                 /              \
           2(-inf, 5)    7(5,7)        12(10,15)       20 (15, +inf)

           Time: O(n)
           Space: O(height)
     */
    public boolean isValidBST (TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean helper (TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        return root.key < max && root.key > min
                && helper (root.left, root.key, min)
                && helper (root.right, max, root.key);
    }
}
