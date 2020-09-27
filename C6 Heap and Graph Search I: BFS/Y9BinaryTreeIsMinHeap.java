import java.util.LinkedList;
import java.util.Queue;

public class Y9BinaryTreeIsMinHeap {

    public boolean isMinHeap (TreeNode root) {
        if (root == null) {
            return true;
        }
        return isHeap(root) && isComplete(root);
    }

    private boolean isHeap (TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null) {
            return false;
        }
        if (root.right == null) {
            return root.key <= root.left.key;
        } else {
            if (root.key <= root.left.key && root.key <= root.right.key) {
                return isHeap(root.left) && isHeap(root.right);
            } else {
                return false;
            }
        }
    }

    private boolean isComplete (TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
