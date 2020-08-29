import java.util.ArrayDeque;
import java.util.Queue;

public class S11MClosestNumberInBinarySearchTreeII {
    /*
     1. we use a queue of size k to simulate a sliding window
     2. run in-order traverse on this BST, and for each new node x
        case 1: if queue < k, we just insert X into the queue
        case 2: if queue.size == k
            case 2.1: if abs(X - target) < abs(queue.poll() = target)
                      we call queue.poll and insert X into the queue
            case 2.2: we return
     Time:      O(n)
     Space:     O(k)
     */
    public int[] closestKValues (TreeNode root, double target, int k) {
        if (k <= 0) return new int[0];
        Queue<Integer> queue = new ArrayDeque<>();
        helper(root, target, k, queue);
        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    private void helper (TreeNode node, double target, int k, Queue<Integer> queue) {
        if (node == null) {
            return;
        }
        helper(node.left, target, k, queue);
        if (queue.size() < k) {
            queue.offer(node.key);
        } else {
            if (Math.abs(target - node.key) < Math.abs(target - queue.peek())) {
                queue.poll();
                queue.offer(node.key);
            } else {
                return;
            }
        }
        helper(node.right, target, k, queue);
    }

}
