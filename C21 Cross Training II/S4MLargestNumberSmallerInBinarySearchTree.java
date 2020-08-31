public class S4MLargestNumberSmallerInBinarySearchTree {
    /*
    Data Structure: maintain a global min_diff
    Algorithm:
    Initialize:  result = MIN_VALUE
    case 1: target <= root.key      -> go left
    case 2: target > root.key       -> go right  & update result

     */
    public int largestSmaller (TreeNode root, int target) {
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;
            }
            else {
                result = root.key;
                root = root.right;
            }
        }
        return result;
    }
}
