public class JZ18MirrorBinaryTree {
    /*
    swap between left and right

    the in current layer :
    swap root.left with root.right

    Mirror (root.left)
    Mirror (root.right)
    TIme: O(n)
    Space: O(h)
     */
    public void Mirror (TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
