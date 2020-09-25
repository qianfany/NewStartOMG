public class Y36DeleteZeroNodesFromLeaf {
    /**
     * Delete the nodes only if its 0 and all the nodes on the leaf
     * sub-problem: root.left, root.right
     * base case: root ==null		return null
     * condition: root.key == 0 && isLeaf 	return null
     * root.left = delete(root.left)		root.right = delete(root.right)
     *
     * @param root
     * @return
     */
    public TreeNode deleteZero (TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = deleteZero(root.left);
        root.right = deleteZero(root.right);

        if (root.key == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
