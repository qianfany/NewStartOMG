public class Y43BinaryTreeLongestConsecutiveSequence {

    public int longestConsecutive (TreeNode root) {
        int[] maxLength = new int[] {0};
        dfs(root, maxLength);
        return maxLength[0];
    }

    private int dfs (TreeNode root, int[] maxLength) {
        if (root == null) return 0;
        int L = dfs(root.left, maxLength) + 1;
        int R = dfs(root.right, maxLength) + 1;
        if (root.left != null && root.key + 1 != root.left.key) {
            L = 1;
        }
        if (root.right != null && root.key + 1 != root.right.key) {
            R = 1;
        }
        int length = Math.max(L, R);
        maxLength[0] = Math.max(maxLength[0], length);
        return length;
    }
}
