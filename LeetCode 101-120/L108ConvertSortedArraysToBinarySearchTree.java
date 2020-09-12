public class L108ConvertSortedArraysToBinarySearchTree {
    /**
     * Preorder Traversal: always choose left middle nodes as a root
     * if left > right, then there is no elements available
     * middle = low + (high = low) /2;
     * root = TreeNode middle
     * compute recursively left and right subtrees root.left = helper (left, p-1)
     * root.right = helper (p+1, right)
     * Time: O(N)
     * Space: O(N) to keep the output and log(N) for the recursion stack
     *
     * @param nums input sorted array
     * @return  binary search tree root
     */
    public TreeNode sortedArrayToBST (int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper (nums, 0, nums.length - 1);
        return head;
    }
    private TreeNode helper (int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) /2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper (nums, mid + 1, high);
        return node;
    }
}
