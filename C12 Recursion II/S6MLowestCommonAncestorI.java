public class S6MLowestCommonAncestorI {

    /*
    Assumptions:
    1. There is no parent pointer for the nodes in binary tree
    2. The given two nodes ar guaranteed to be in the binary tree

    case 1: a and b
        base case
            if current == a || current == b -> return current
            if current == null                  return current
        recursive rule
            case 1.1  if left returns null && right returns null
                return null to my parent
            case 1.2  if either left or right return non-null
                return the non-null side to my parent
            case 1.3  if both return non-null,
                return myself

     */
    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
