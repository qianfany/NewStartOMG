public class S11EInsertInBinarySearchTree {
    /*
    Time: O(h)
    Space: O(h)

    root.left = insert (root.left, key)
    root.right = insert (root.right, key)
     */
    public TreeNode insert (TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.key) {
            root.left = insert (root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l3 = new TreeNode(3);
        TreeNode l8 = new TreeNode(8);
        TreeNode l1 = new TreeNode(1);
        TreeNode l4 = new TreeNode(4);
        root.left = l3;
        root.right = l8;
        l3.left = l1;
        l3.right = l4;
        S11EInsertInBinarySearchTree sol = new S11EInsertInBinarySearchTree();
        System.out.println(sol.insert(root, 11));
    }
}
