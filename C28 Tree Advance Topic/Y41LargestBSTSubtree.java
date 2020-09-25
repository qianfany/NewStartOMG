public class Y41LargestBSTSubtree {

    public int largestBSTSubtree (TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }

    private int[] largestBST (TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = largestBST(root.left);
        int[] right = largestBST(root.right);
        if (root.key > left[1] && root.key < right[0]) {
            return new int[]{Math.min(root.key, left[0]),
            Math.max(root.key, right[1]), left[2] + right[2] + 1};
        }
        else {
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}
