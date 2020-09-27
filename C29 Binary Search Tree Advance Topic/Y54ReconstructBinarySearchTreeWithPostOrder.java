public class Y54ReconstructBinarySearchTreeWithPostOrder {

    public TreeNode reconstruct (int[] post) {
        int[] index = new int[] {0};
        return helper (post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper (int[] post, int[] index, int min) {
        if (index[0] < 0 || post[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(post[index[0]--]);
        root.right = helper(post, index, root.key);
        root.left = helper(post, index, min);
        return root;
    }
}
