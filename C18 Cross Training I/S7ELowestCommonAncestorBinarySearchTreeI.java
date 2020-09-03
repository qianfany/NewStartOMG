public class S7ELowestCommonAncestorBinarySearchTreeI {
    /*
    find the min and max of two nodes
    root is the Lowest common ancestor
    iff    root >= small && root <= large
    initialize: root
    case 1: root.key >= small && root.key <= large
        return root
    case 2: root.key < small    root = root.right
    case 3: root.key > large    root = root.left
    termination condition: root == null
    time:   O(height)
    Space:  O(1)
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
