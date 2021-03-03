public class L129SumRootToLeafNumbers {
    /*
                       4(4)
                    /      \
                9(49)       0 (40)
                 /   \
             5(495)   1(491)

      @param root
      @return
      Time : O(N)
      Space: O(H)
     */
    public int sumNumbers (TreeNode root) {
        return sumNodes(root, 0);
    }

    private int sumNodes (TreeNode root, int currentSum) {
        if (root == null) return 0;
        currentSum = currentSum * 10 + root.key;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        int leftSum = sumNodes(root.left, currentSum);
        int rightSum = sumNodes(root.right, currentSum);
        return leftSum + rightSum;
    }
}
