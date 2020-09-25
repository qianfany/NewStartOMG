public class Y39CheckTreeIsFull {

    public boolean isFull (TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isFull(root.left) && isFull(root.right);
        }
        return false;
    }
}
