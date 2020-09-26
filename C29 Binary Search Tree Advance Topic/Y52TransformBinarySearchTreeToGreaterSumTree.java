public class Y52TransformBinarySearchTreeToGreaterSumTree {

    public TreeNode greaterSum (TreeNode root) {
        int[] sum = new int[] {0};
        formSum(root, sum);
        return root;
    }

    private void formSum (TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        formSum(root.right, sum);
        int value = root.key;
        root.key = sum[0];
        sum[0] = sum[0] + value;
        formSum(root.left, sum);
    }
}
