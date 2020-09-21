import java.util.ArrayList;
import java.util.List;

public class S2EInOrderTraversalRecursive {
    /*
    [left][root][right]
     */
    public List<Integer> inOrder (TreeNode root) {
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

    public void inorder (TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }
}
