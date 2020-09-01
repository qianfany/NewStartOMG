public class S2MMaxPathSumFromLeafToRoot {
    // Bottom up return the max suffix sum
    public int maxPathSumLeafToRoot (TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.key;
        }
        if (root.left == null) {
            return maxPathSumLeafToRoot(root.right) + root.key;
        }
        if (root.right == null) {
            return maxPathSumLeafToRoot(root.left) + root.key;
        }
        return root.key + Math.max(maxPathSumLeafToRoot(root.left),
                maxPathSumLeafToRoot(root.right));
    }


    // pass down the prefix sum

    public int maxPathSumII (TreeNode root) {
        return maxPathSum(root, 0);
    }

    private int maxPathSum (TreeNode root, int sum) {
        sum += root.key;
        if (root.left == null && root.right == null) {
            return sum;
        }
        else if (root.left == null) {
            return maxPathSum(root.right, sum);
        }
        else if (root.right == null) {
            return maxPathSum(root.left, sum);
        }
        return Math.max(maxPathSum(root.left, sum), maxPathSum(root.right, sum));
    }
}
