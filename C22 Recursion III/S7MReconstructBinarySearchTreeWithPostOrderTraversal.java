public class S7MReconstructBinarySearchTreeWithPostOrderTraversal {
    /*
    Only for binary search tree
                    5
                 /     \
                3       8
              /  \        \
             1    4        11
     {1, 4, 3, 11, 8, 5}
            1 4 3       11 8    5(r)
            1 4     3(r)     11  8(r)
            1   4

     */
    public TreeNode reconstruct (int[] post) {
        int[] index = new int[] {post.length -1};
        return helper (post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper (int[] postOrder, int[] index, int min) {
        if (index[0] < 0 || postOrder[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[index[0]]--);
        root.right = helper(postOrder, index, root.key);
        root.left = helper(postOrder, index, min);
        return root;
    }
}
