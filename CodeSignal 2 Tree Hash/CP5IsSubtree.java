public class CP5IsSubtree {
    /**
     *  base case:
     *      subtree == null                     return true
     *      root == null && subtree != null     return false
     *
     *  recursive rule:
     *      check if root1.value == root2. value
     *          if true: recursively check the whole tree
     *          otherwise: check if root1.left or root1.right
     *
     *  Time: O(m n)
     *  Space: O(n)
     * @param t1
     * @param t2
     * @return
     */
    public boolean isSubtree (TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;

        if (t1 == null)
            return false;

        if (judge(t1, t2)) {
            return true;
        }
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    private boolean judge (TreeNode root, TreeNode subtree) {
        if (subtree == null && root == null) {
            return true;
        }
        if (root == null || subtree == null) {
            return false;
        }
        return root.key == subtree.key && judge(root.left, subtree.left)
                && judge(root.right, subtree.right);
    }
}
