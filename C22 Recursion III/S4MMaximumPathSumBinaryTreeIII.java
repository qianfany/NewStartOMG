public class S4MMaximumPathSumBinaryTreeIII {
    /*
    must be up down path
    Solution: max subarray sum
    M[i] = the largest sum of a subarray that ends at a[i]
    M[0] = a[0]
    M[i] = if M[i - 1] < 0  then   [a[i]]
           otherwise        M[i-1] + a[i]

    for lchild / rchild
    left : max single path in my left sub tree that starts from lchild
    right: max single path in my right subtree that starts from rchild
    current layer
    update global_max with max(left, right, 0) + root.key
    parent
    max(left, right, 0) + root.key
    Time: O(n)
     */
    public int maxPathSum (TreeNode root) {
        int sum = -1;
        int[] max = new int[] {Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper (TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        int sum = Math.max(Math.max(left, right), 0) + root.key;
        max[0] = Math.max(max[0], sum);
        return sum;
    }
}
