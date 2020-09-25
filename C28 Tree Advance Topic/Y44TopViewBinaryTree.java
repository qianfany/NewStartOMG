import java.util.*;

public class Y44TopViewBinaryTree {

    class Pair {
        TreeNode node;
        int col;
        public Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // help with level order traversal
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        // store temp result
        // if node's column is less than left range, append at head
        // if node's column is larger than right range, append at tail
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(root.key);
        // store the current column range from left most to right most
        int[] range = new int[]{0,0};
        while(! queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.node.left != null) {
                // compute column of left child
                int col = cur.col - 1;
                if (col < range[0]) {
                    // add this new left most node to head of deque
                    deque.addFirst(cur.node.left.key);
                    // update range
                    range[0] = col;
                }
                queue.add(new Pair(cur.node.left, col));
            }
            if (cur.node.right != null) {
                int col = cur.col + 1;
                if (col > range[1]) {
                    deque.addLast(cur.node.right.key);
                    range[1] = col;
                }
                queue.add(new Pair(cur.node.right, col));
            }
        }
        // mode to result list
        while(! deque.isEmpty()) {
            res.add(deque.pollFirst());
        }
        return res;
    }

}
