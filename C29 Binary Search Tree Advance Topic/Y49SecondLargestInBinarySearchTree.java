public class Y49SecondLargestInBinarySearchTree {

    public int secondLargest (TreeNode root) {
        int res;
        TreeNode prev = root;
        TreeNode cur = root;
        while (cur.right != null) {
            prev = cur;
            cur = cur.right;
        }
        if (cur.left != null) {
            cur = cur.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            res = cur.key;
        } else {
            if (cur == root && prev == root) {
                res = Integer.MIN_VALUE;
            } else {
                res = prev.key;
            }
        }
        return res;
    }
}
