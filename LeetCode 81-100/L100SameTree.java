public class L100SameTree extends BaseObject {
    /*
    O(m) number of treeNode, all the treeNode will be traversed once
     */
    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
