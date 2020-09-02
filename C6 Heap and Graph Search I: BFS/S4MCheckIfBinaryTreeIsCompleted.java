import java.util.LinkedList;
import java.util.Queue;

public class S4MCheckIfBinaryTreeIsCompleted {
    /*
    Definition of complete binary tree:
    A binary tree is a complete binary tree if all the levels are completely filled
    except possibly the last level and the last level has all keys as left as possible

    if we find a bubble, we cannot get number any more
    algorithm: BFS (Breath First Search)
    Data Structure: FIFO queue, flag: whether I detected bubbles
    Expand:
        When the flag is false, if the left child or the right child is null,
        set the flag
        when the flag is true, if the left child or the right child is not null,
        return false
    Terminate:
    queue is empty or return false
    Time: O(n)
    Space: O(n)
     */

    public boolean isCompleted (TreeNode root) {
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
                // if flag is true, still see cur has a left child
                // this is not complete
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                // if flag is true, still see cur has a right child
                // this is not complete
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
