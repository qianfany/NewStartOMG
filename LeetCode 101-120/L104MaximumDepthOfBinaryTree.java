public class L104MaximumDepthOfBinaryTree {
    /**
     * Time: O(n) n is total number of nodes in the tree
     * Space: O(h) worst case
     * @param root
     * @return maximum depth
     */
    public int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
