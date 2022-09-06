public class S6MLowestCommonAncestorI extends BaseObject{

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
    public TreeNode lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        S6MLowestCommonAncestorI sol = new S6MLowestCommonAncestorI();
        TreeNode res = sol.lowestCommonAncestor(root, 5, 4);
        System.out.println(res.val);
    }
}
