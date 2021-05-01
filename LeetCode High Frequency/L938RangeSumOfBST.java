import java.util.ArrayDeque;
import java.util.Deque;

public class L938RangeSumOfBST {
    /*
    inorder traversal of a binary search tree
     */
    public int rangeSumBST (TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        int res = 0;
        while (cur != null || stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                if (cur.key >= low && cur.key <= high) {
                    res += cur.key;
                }
                cur = cur.right;
            }
        }
        return res;
    }
}
