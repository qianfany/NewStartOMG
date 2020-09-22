import java.util.ArrayList;
import java.util.List;

public class Y20EBinaryTreePaths {
    /**
     * Recursion, going through the tree by considering at each step the node
     * itself and its children. If node is not a leaf, one extends the current
     * path by a node value and calls recursively the path construction
     * for its children, if node is a leaf, closes the current path and
     * adds it into the list of paths
     * Time:    O(N)        Space:  O(N)
     * @param root
     * @return
     */
    public List<String> binaryTreePath (TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper (root, "", res);
        return res;
    }

    private void helper (TreeNode root, String parentPath, List<String> list) {
        String cur = null;
        if (parentPath != "") {
            cur = parentPath + "->" + root.key;
        } else {
            cur = parentPath + root.key;
        }
        if (root.left != null) {
            helper(root.left, cur, list);
        }
        if (root.right != null) {
            helper(root.right, cur, list);
        }
        if (root.left == null && root.right == null) {
            list.add(cur);
        }
    }


}
