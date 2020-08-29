public class S7ELowestCommonAncestorBinarySearchTreeI {
    /*
    root is the Lowest common ancestor
    iff    root >= small && root <= large
     */
    public TreeNode lca (TreeNode root, int p, int q) {
        int small = Math.min(p, q);
        int large = Math.max(p, q);
        while (root != null) {
            if (root.key < small) {
                root = root.right;
            } else if (root.key > large) {
                root = root.left;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
