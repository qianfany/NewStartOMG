import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L94BinaryTreeInOrderTraversal {

    public List<Integer> inoderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper (root, list);
        return list;
    }

    private void helper (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper (root.left, res);
        res.add(root.key);
        helper(root.right, res);
    }

    public List<Integer> inorder (TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pollFirst();
                list.add(cur.key);
                cur = cur.right;
            }
        }
        return list;
    }
}
