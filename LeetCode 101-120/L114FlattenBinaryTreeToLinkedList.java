public class L114FlattenBinaryTreeToLinkedList {
    /*
    do post order traversal from right to left
    we need to record the previous node

                    1
                  /    \
                 2      5
               /   \      \
              3     4      6
     Post-Order Traversal [right][left][root]  ->     {6, 5, 4, 3, 2, 1}
     */
    public void flatten (TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper (root, prev);
    }

    private void helper (TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        helper(root.right, prev);
        helper (root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }
    public static void main (String[] args) {
        L114FlattenBinaryTreeToLinkedList sol = new L114FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(5);
        TreeNode r2 = new TreeNode(2);
        TreeNode r11 = new TreeNode(11);
        TreeNode r6 = new TreeNode(6);
        TreeNode r14 = new TreeNode(14);
        root.left = r2;
        root.right = r11;
        r11.left = r6;
        r11.right = r14;
        sol.flatten(root);
    }
}
