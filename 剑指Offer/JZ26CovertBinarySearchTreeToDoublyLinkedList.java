import java.util.ArrayDeque;
import java.util.Deque;


public class JZ26CovertBinarySearchTreeToDoublyLinkedList {
    /*
    1. do inorder traversal
    2. update the current TreeNode pointer with the previous TreeNode pointer
    Time:   O(n)
    Space:  O(n)
     */
    public TreeNode convert (TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur =pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            if (isFirst) {
                pRootOfTree = cur;
                pre = cur;
                isFirst = false;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return pRootOfTree;
    }
}
