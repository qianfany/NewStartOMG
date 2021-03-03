import java.util.*;

public class Y18HLowestCommonAncestorIII {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = LCA(root, p, q);
        if(lca == p) {
            return findNode(p, q)? lca : null;
        } else if(lca == q) {
            return findNode(q, p)? lca : null;
        }
        return lca;
    }

    private TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
        if(root == null || root.key == one.key || root.key == two.key) {
            return root;
        }
        TreeNode left = LCA(root.left, one, two);
        TreeNode right = LCA(root.right, one, two);
        if(left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    private boolean findNode(TreeNode root, TreeNode node) {
        if(root == null) {
            return false;
        }
        if(node == root) {
            return true;
        }
        return findNode(root.left, node) || findNode(root.right, node);
    }
}
