public class CP1HasPathRootToPathWithGivenSum {

    public boolean hasPath (TreeNode t, int s) {
        if (t == null) return false;
        s -= t.key;

        if (s == 0 && t.left == null && t.right == null) {
            return true;
        }
        return hasPath(t.left, s) || hasPath(t.right, s);

    }
}
