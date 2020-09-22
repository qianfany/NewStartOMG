public class Y17MCountUniValSubtrees {

    /**
     *  first do PreOrder traversal for every node
     *  for each node, check if itself and below are uniValue
     *  Not a very good solution
     *  Time: O(N^2)        Space: O(N)
     * @param root
     * @return
     */
    public int countUniValSubtrees (TreeNode root) {
        if (root == null) return 0;
        int count = isUniValue(root) ? 1 : 0;
        return count + countUniValSubtrees(root.left) + countUniValSubtrees(root.right);
    }

    private boolean isUniValue (TreeNode node) {
        boolean check = true;
        if (node.left != null) {
            check = check && (node.left.key == node.key);
            check &= isUniValue(node.left);
        }
        if (node.right != null) {
            check = check && (node.right.key == node.key);
            check &= isUniValue(node.right);
        }
        return check;
    }
}
