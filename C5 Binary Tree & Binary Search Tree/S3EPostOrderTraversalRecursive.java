import java.util.ArrayList;
import java.util.List;

public class S3EPostOrderTraversalRecursive {
    /*
    [left][right][root]

     */
    public List<Integer> postOrder (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper (root, res);
        return res;
    }

    private void helper (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper (root.left, res);
        helper(root.right, res);
        res.add(root.key);
    }
}
