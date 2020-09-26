import java.util.*;

public class Y48BClosestNumberInBinarySearchTreeII {

    public int[] closestKValues (TreeNode root, double target, int k) {
        if (k <= 0) return new int[0];
        Queue<Integer> queue = new ArrayDeque<>();
        helperI(root, target, k, queue);
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

    private void helperI (TreeNode node, double target, int k, Queue<Integer> queue) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pollFirst();
                if (queue.size() < k) {
                    queue.offer(cur.key);
                } else {
                    if (Math.abs(target - cur.key) < Math.abs(target - queue.peek())) {
                        queue.poll();
                        queue.offer(cur.key);
                    }
                }
                cur = cur.right;
            }
        }
    }

    public static void main (String[] args) {
        Y48BClosestNumberInBinarySearchTreeII sol = new Y48BClosestNumberInBinarySearchTreeII();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.print(Arrays.toString(sol.closestKValues(root, 1000, 2)));
    }

}
