import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L102BinaryTreeLevelOrderTraversal {
    /**
    DFS approach:
                        4
                    /       \
                  2         10
                        /       \
                       15       7
     compare the number of current level len(levels) node level.
     if still on the previous level, add the new one by adding a new list into level
     Time: O(n)
     Space: O(n)
     */
    public List<List<Integer>> levelOrder (TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        helper (root, 0, levels);
        return levels;
    }


    private void helper (TreeNode root, int height, List<List<Integer>> levels) {
        if (root == null) {
            return;
        }
        if (height == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(height).add(root.key);
        helper(root.left, height + 1, levels);
        helper(root.right, height + 1, levels);
    }
    /**
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
    public List<List<Integer>> levelOrderBSF (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int size = queue.size();
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
