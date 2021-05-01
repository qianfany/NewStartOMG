import java.util.ArrayList;
import java.util.List;

public class L34二叉树中和胃某一值的路径 {

    public List<List<Integer>> pathSum (TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper (root, target, list, res);
        return res;
    }

    private void helper (TreeNode root, int target, List<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        list.add(root.key);
        target -= root.key;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        helper(root.left, target, list, res);
        helper(root.right, target, list, res);
        list.remove(list.size() - 1);
    }
}
