import java.util.LinkedList;
import java.util.Queue;

public class L116PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node () {}
        public Node (int val) {
            this.val = val;
        }
        public Node (int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    /**
     * Breath First Search
     * keep track of number of queue, in the same queue means in the same level from
     * left to right
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @return
     */
    public Node connect (Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
