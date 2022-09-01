public class L2231EvaluateBooleanBinaryTree extends BaseClass{

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }
    public boolean dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return dfs(root.left) || dfs(root.right);
        } else {
            return dfs(root.left) && dfs(root.right);
        }
    }
}
