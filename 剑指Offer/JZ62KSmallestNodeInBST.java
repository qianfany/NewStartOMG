import java.util.ArrayDeque;
import java.util.Deque;

public class JZ62KSmallestNodeInBST {
    /*
    Assume k > 0
    InOrder Traversal iteratively
    keep track of the elements come out of the stack
    Time: O(n)
    Space: O(n)
     */
    public TreeNode kthNode (TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = pRoot;
        while ( cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pollFirst();
                k--;
                if (k == 0) {
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}
