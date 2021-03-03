import java.util.ArrayDeque;
import java.util.Deque;

public class L99RecoverBinarySearchTree {
    /*
    Exactly two elements are swapped

    Iterative Inorder Traversal

    identify swapped nodes, track the last node in the inorder traversal
    and compare it with current node value.
    if the current node is smaller than its predecessor, it is the swapped node
    Time: O(n)
    Space: O(n)
     */
    public void recoverTree (TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pre = null;
        TreeNode root1  = root;

        while (!stack.isEmpty() || root1 != null) {
            while (root1 != null) {
                stack.offerFirst(root1);
                root1 = root1.left;
            }
            root1 = stack.pollFirst();
            if (pre != null && root1.key < pre.key) {
                y = root1;
                if (x == null) {
                    x = pre;
                }
                else {
                    break;
                }
            }
            pre = root1;
            root1 = root1.right;
        }
        swap(x, y);
    }

    private void swap (TreeNode a, TreeNode b) {
        int tmp = a.key;
        a.key = b.key;
        b.key = tmp;
    }
}
