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
}
