import java.util.ArrayDeque;
import java.util.Deque;

public class L783MinimumDistanceBetweenBSTNodes {
    /*
    In order traverse

     */
    public int minDiffInBST (TreeNode root) {
        int Min = Integer.MAX_VALUE;
        int prev = Integer.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pollFirst();
                if (prev != Integer.MIN_VALUE) {
                    Min = Math.min(Min, cur.key - prev);
                }
                prev = cur.key;
                cur = cur.right;
            }
        }
        return Min;
    }
}
