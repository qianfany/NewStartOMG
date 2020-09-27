public class Y55ReconstructBinarySearchTreeWithPostOrder {

    public TreeNode reconstruct(int[] level) {
        TreeNode root = null;
        for (int i = 0; i < level.length; i++) {
            root = helper(root, level[i]);
        }
        return root;
    }
    private TreeNode helper(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data <= root.key) {
            root.left = helper(root.left, data);
        }
        if (data > root.key){
            root.right = helper(root.right, data);
        }
        return root;
    }


}
