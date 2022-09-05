import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L102BinaryTreeLevelOrderTraversal extends BaseObject {
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
        levels.get(height).add(root.val);
        helper(root.left, height + 1, levels);
        helper(root.right, height + 1, levels);
    }

    public static void main(String[] args) {
        L102BinaryTreeLevelOrderTraversal sol = new L102BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.levelOrder(root));
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
                4
             /       \
            2         10
                   /       \
                 15         7
     [4]            size = 1    queue.poll()
     add 4.left
     add 4.right
     [2, 10]        size = 2    queue.poll()
     2.left = null 2.right = null
     queue.poll()
     add 10.left
     add 10.right
     [15, 7]
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
                curList.add(cur.val);
            }
            result.add(curList);
        }
        return result;
    }
}
