public class JZ17HasSubtree {
    /*
    check if root2 is the subtree of root1

    base case:
    subtree == null
        return true
    root == null && subtree != null
        return false
    recursive rule:
        check if root1.key == root2.key
            if true:  recursively check the next TreeNode
                      (root.left, subtree.left) && (root.right, subtree.right)
            otherwise: check if root1.left or root1.right
    Time:   O(mn)
    Space: O(n)
     */
    public boolean hasSubtree (TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (root1.key == root2.key) {
            if (judge(root1, root2)){
                return true;
            }
        }
        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean judge (TreeNode root, TreeNode subtree) {
        if (subtree == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.key == subtree.key) {
            return judge(root.left, subtree.left) && judge(root.right, subtree.right);
        }
        return false;
    }
}
