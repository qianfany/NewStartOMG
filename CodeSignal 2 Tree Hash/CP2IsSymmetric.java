public class CP2IsSymmetric {
    /**
     *          4                               4
     *        /   \                          /     \
     *       1     2                        2       1
     *      /                                         \
     *     6                                            6
     *   Time: O(n/2) = O(n)
     *   recursion tree (n/2 node)
     *   Space: O(height)
     *
     * @param t
     * @return
     */
    public boolean isTreeSymmetric (TreeNode t) {
        if (t == null) {
            return true;
        }
        return isTreeSymmetric(t.left, t.right);
    }

    private boolean isTreeSymmetric (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left == null || right == null) {
            return false;
        }
        else if (left.key != right.key) {
            return false;
        }
        return isTreeSymmetric(left.left, right.right)
                && isTreeSymmetric(left.right, right.left);
    }
}
