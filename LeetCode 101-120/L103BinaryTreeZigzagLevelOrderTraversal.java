import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L103BinaryTreeZigzagLevelOrderTraversal {
    /*
    Data Structure
    Deque: all nodes in the current level from left to right leaf
    Algorithm:
        Initialize: deque = {root}
    In each step:
        1. record the old deque size
        2. even level: from left to right expand
            a. generate left, insert to the right
            b. generate right, insert to the right
        3. odd level: from right to left expand
            a. generate right, insert to the left of deque
            b. generate left, insert to the left
     Termination Condition: the deque is empty
     Time: O(n)
     Space: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder (TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (layer == 1) {
                    TreeNode tmp = deque.pollLast();
                    list.add(tmp.key);
                    if (tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }
                } else {
                    TreeNode tmp = deque.pollFirst();
                    list.add(tmp.key);
                    if  (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                }
            }
            res.add(list);
            layer = 1 ^ layer;
        }
        return res;
    }
}
