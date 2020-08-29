public class S4EHeightOfBinaryTree {
    /*
    Time: O(n) n is the total number of nodes in the tree
    Space: O(h) worst case
     */
    public int findHeight (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
}
