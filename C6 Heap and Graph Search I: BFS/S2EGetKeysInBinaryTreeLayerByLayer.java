import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S2EGetKeysInBinaryTreeLayerByLayer {
    /*
    Data Structure: FIFO queue
    Algorithm: BFS1
    Initialization: queue = {root}
    for each step:
        1. record the size (k) of queue
        2. k time expand + generate
    Time:   O(n)
    Space:  O(n)
     */
    public List<List<Integer>> layerByLayer (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // corner case
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int size = queue.size();
            // size = # of nodes in the cur Layer
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                curList.add(cur.key);
            }
            result.add(curList);
        }
        return result;
    }
}
