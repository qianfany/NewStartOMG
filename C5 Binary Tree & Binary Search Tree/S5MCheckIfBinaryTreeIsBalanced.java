public class S5MCheckIfBinaryTreeIsBalanced {
    /*
    base case: root == null return true
    recursive rule: isBalanced(root.left) && isBalanced(root.right)
    Height = log (n) levels
    Each level time = O(n)
    thus total time = n * log n = O(n log n)
     */
    public boolean isBalancedI (TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalancedI(root.left) && isBalancedI(root.right);
    }

    private int getHeight (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /*
    optimal solution:
    base case:
    dont need call getHeight again
    Time: O(n)
    use -1 to denote the tree is not balanced
    >= 0 value means that tree is balanced and its the height of the tree
    for lchild / rchild
    two meanings: >= 0 : height(lchild);  -1: lchild is not balanced
    two meanings: >= 0 : height(rchild);  -1: rchild is not balanced
    for current layer
    case 1: if lchild is not balanced or rchild is not balanced, then return -1
    case 2: both balanced, check |height(lchild) - height(rchild)| <= 1
    report to your parent, max(height(lchild), height(rchild) + 1; or -1 if not balanced)
     */

    public boolean isBalanced2 (TreeNode root) {
        if (root == null ) {
            return true;
        }
        return height(root) != -1;
    }

    private int height (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        // if left subtree is already not balanced, we do not need to continue
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
