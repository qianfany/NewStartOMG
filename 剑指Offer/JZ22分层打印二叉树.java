import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ22分层打印二叉树 {
    /*
    Data Structure: FIFO queue
    Algorithm: BFS1
    Initialization: queue = {root}
    for each step:
        1. record the size (k) of queue
        2. k time expand + generate
    Termination condition:
        the queue is empty
    Time:   O(n)
    Space:  O(n)
     */
    public ArrayList<Integer> printLevelByLevel (TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                result.add(cur.key);
            }
        }
        return result;
    }
}
