
import java.util.ArrayList;
import java.util.List;

public class S1EPreOrderTraversalRecursive {
    /*
    [root] [left] [right]

     */
    public List<Integer> preOrder (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper (root, res);
        return res;
    }
    private void helper (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.key);
        helper (root.left, res);
        helper(root.right, res);
    }

    public void preOrderI (TreeNode root) {
        if (root == null) return;
        System.out.println(root.key);
        preOrderI(root.left);
        preOrderI(root.right);
    }
}
