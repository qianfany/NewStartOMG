import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class M7MGetKeysInBinaryTreeLayerZigZagOrder {
    /*
    Data Structure
    Deque: all nodes in the current level from left to right leve
    Algorithm:
        Initialize: deque = {root}
    In each step:
        1. record the old size
        2. odd level: from left to right expand
            a. generate left, insert to the right
            b. generate right, insert to the right
        3. even level: from right to left expand
            a. generate right, insert to the left of deque
            b. generate left, insert to the left
     */
    public List<Integer> zigZag (TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
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
                    if (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return list;

    }
}
