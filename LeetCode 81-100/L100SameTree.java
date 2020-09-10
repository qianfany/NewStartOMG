public class L100SameTree {

    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.key != q.key) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
