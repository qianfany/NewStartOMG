public class L26树的字结构 {
    /*

     */
    public boolean isSubStructure (TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (judge(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean judge (TreeNode root, TreeNode subtree) {
        if (subtree == null ) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return root.key == subtree.key && judge(root.left, subtree.left)
                && judge(root.right, subtree.right);
    }
}
