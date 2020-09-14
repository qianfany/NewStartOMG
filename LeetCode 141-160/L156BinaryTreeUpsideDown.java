public class L156BinaryTreeUpsideDown {
    /**
     * base case
     * root == null || root.left == null && root.right == null
     * subproblem
     * root.left
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree (TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }
}
