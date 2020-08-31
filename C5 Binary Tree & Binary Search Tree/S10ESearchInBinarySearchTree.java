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
}
