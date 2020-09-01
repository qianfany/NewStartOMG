public class S1HMaximumPathSumBinaryTreeII {
    /*
    find the maximum possible sum from any node to any node

    for lchild / rchild
    left: max single path in my left subtree that starts from lchild
    right: max single path in my right subtree that starts from rchild
    for current layer
    update globalMax with max(left, 0) + max(right, 0) + root.value
    for report to parent
    return root.value + max(left, right, 0)
     */
    public int maxPathSum (TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        helper (root, max);
        return max[0];
    }

    private int helper (TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(root.key + left + right, max[0]);
        return root.key + Math.max(left, right);
    }
}
