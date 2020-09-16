import java.util.ArrayDeque;
import java.util.Deque;

public class CP4KthSmallestInBST {
    /**
     * Inorder traversal iteratively
     * @param t
     * @param k
     * @return
     */
    public int kthSmallestBST (TreeNode t, int k) {
        if (t == null || k == 0) {
            return -1;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = t;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pollFirst();
                k--;
                if (k == 0) {
                    return cur.key;
                }
                cur = cur.right;
            }
        }
        return -1;
    }
}
