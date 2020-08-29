public class S8MIsBinarySearchTreeOrNot {
    /*
                    10 (-inf, +inf)
                  /                    \
               5(-inf,10)               15(10, +inf)
            /           \                 /              \
           2(-inf, 5)    7(5,7)        12(10,15)       20 (15, +inf)
     */
    public boolean isBST (TreeNode root) {
        return helper (root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean helper (TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        return root.key < max && root.key > min
                && helper (root.left, root.key, min)
                && helper (root.right, max, root.key);
    }
}
