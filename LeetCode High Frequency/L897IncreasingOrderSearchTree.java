import java.util.ArrayList;
import java.util.List;

public class L897IncreasingOrderSearchTree {

    public TreeNode increasingBST (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int val : res) {
            currNode.right = new TreeNode(val);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    private void inorder (TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.key);
        inorder(node.right, res);
    }
}
