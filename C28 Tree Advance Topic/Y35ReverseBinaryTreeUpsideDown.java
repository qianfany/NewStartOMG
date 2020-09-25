public class Y35ReverseBinaryTreeUpsideDown {
    /**
     *          1							         3
     *
     *       /    \					            /        \
     *
     *     2        5					       2	      5
     *
     *   /   \						        /     \
     *
     * 3      4					          3	       4
     * Recursion:
     * apart from subproblem:
     * root.left.left = root.right
     * root.left.right = root
     * root.left = null
     * root.right = null
     *
     * @param root
     * @return
     */
    public TreeNode reverse (TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
