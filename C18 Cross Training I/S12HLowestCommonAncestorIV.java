import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S12HLowestCommonAncestorIV {
    /*
    case 1: if all nodes are under root, return LCA of these nodes
    case 2: if a subset of the given nodes are under root,
            return LCA of the nodes under root
    case 3: if none of the nodes are under root, return null
     */
    public TreeNode lowestCommonAncestor (TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>(nodes);
        return helper (root, set);
    }

    private TreeNode helper (TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
