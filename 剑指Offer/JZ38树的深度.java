public class JZ38树的深度 {
    /*
    Time: O(n) n is the total number of nodes in the tree
    Space: O(h) worst case
     */
    public int TreeDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
