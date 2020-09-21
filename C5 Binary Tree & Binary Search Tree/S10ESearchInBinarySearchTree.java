public class S10ESearchInBinarySearchTree {
    /*
    Binary Search Tree satisfy the properties that
    all left tree elements are smaller than root
    all right tree elements are larger than root
    termination condition: cur == null || cur.key == key
    Time: O(log n)
     */
    public TreeNode search (TreeNode root, int key) {
        TreeNode cur = root;
        while (cur != null && cur.key != key) {
            cur = key < cur.key ? cur.left : cur.right;
        }
        return cur;
    }

    /**
     * Sol 2. Recursive
     * process root
     * check left node if target less than root.key
     * check right node if target greater than root.key
     * Tail recursion
     */

    public TreeNode searchRecursive (TreeNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return searchRecursive(root.right, key);
        }
        else {
            return searchRecursive(root.left, key);
        }
    }
}
