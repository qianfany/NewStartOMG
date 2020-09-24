import java.util.LinkedList;
import java.util.Queue;

public class Y31ReconstructCompleteFromLevelOrder {

    public TreeNode construct (int[] level) {
        if (level == null || level.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(level[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < level.length) {
            TreeNode cur = queue.poll();
            cur.left = new TreeNode(level[i++]);
            queue.add(cur.left);
            if (i < level.length) {
                cur.right = new TreeNode(level[i++]);
                queue.add(cur.right);
            }
        }
        return root;
    }
}
