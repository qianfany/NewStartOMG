public class S6MSymmetricBinaryTree {
    /*
    Time: O(n/2) = O(n)
    recursion tree (n/2 nodes)
    Space: O(height)
                4                                   4
             /     \                             /     \
            1       2                           2       1
          /                                               \
         6                                                  6
     */
    public boolean isSymmetric (TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left == null || right == null) {
            return false;
        }
        else if (left.key != right.key) {
            return false;
        }
        return isSymmetric(left.left, right.right)
                && isSymmetric(left.right. right.left);
    }
}
