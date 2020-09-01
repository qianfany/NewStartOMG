import java.util.HashSet;
import java.util.Set;

public class S3MBinaryTreePathSumToTargetIII {
    /*
    Determine if there exists a path from any node to any node up and down sum of the numbers
    is equal to the given target number

    Solution: (recursion + Dynamic programming path-prefix in hashset)
    Pre-order to iterate over the whole tree, and for each current node X, instead of doing a
    for loop, we maintain a path_prefix sum
    the hashset contain all path_prefix_sum from root node to the current node
    a subarray sum
    O(n) time
     */
    public boolean exist (TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSums = new HashSet<>();
        prefixSums.add(0);
        return helperII (root, prefixSums, 0, target);
    }

    private boolean helperII (TreeNode root, Set<Integer> prefixSums, int prevSum, int sum) {
        prevSum += root.key;
        if (prefixSums.contains(prevSum - sum)) {
            return true;
        }
        boolean needRemove = prefixSums.add(prevSum);
        if (root.left != null && helperII(root.left, prefixSums, prevSum, sum)) {
            return true;
        }
        if (root.right != null && helperII(root.right, prefixSums, prevSum, sum)) {
            return true;
        }
        if (needRemove) {
            prefixSums.remove(prevSum);
        }
        return false;
    }
}
