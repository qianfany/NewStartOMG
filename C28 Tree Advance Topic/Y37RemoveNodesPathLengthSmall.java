public class Y37RemoveNodesPathLengthSmall {
    /**
     * Use post order Traversal of the tree. Before removing a node
     * we need to check that all the children of that node in the shorter path are already removed.
     * i) this node becomes a leaf node in which case it needs to be deleted
     * ii) this node has other child on a path with path length >= k,
     * in that case, it needs not to be deleted
     * Time: O(N)				Space:	O(H)
     * @param root
     * @param k
     * @return
     */
    public TreeNode trimTree (TreeNode root, int k) {
        return remove(root, 1, k);
    }

    private TreeNode remove (TreeNode root, int level, int k) {
        if (root == null) {
            return null;
        }
        root.left = remove(root.left, level + 1, k);
        root.right = remove(root.right, level + 1, k);

        if (root.left == null && root.right == null && level < k) {
            return null;
        }
        return root;
    }
}
