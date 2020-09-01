public class M2MaxPathSumBinaryTreeI {
    /*

        Left: maximum "root to leaf" path sum of left subtree
        right: maximum "root to leaf" path sum of right subtree
        calculate left + right + root.val
        update globalMax if possible
        maximum path sum from root to leaf
        return max(left, right) + root.val

        1                   1                   1                       1
      /   \               /   \               /   \                   /   \
     3    4              null  -3            4     null             null   null
        T: O(n)
        S: O(height)

     */
    public int maxSum (TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper (root, max);
        return max[0];
    }

    private int helper (TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], root.key + left + right);
            return Math.max(left, right) + root.key;
        }
        return root.left == null ? (right + root.key) : (left + root.key);
    }
}
