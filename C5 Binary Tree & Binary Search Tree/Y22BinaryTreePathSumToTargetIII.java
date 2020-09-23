import java.util.HashSet;
import java.util.Set;

public class Y22BinaryTreePathSumToTargetIII {
    /**
     *  from one node to its descendants
     * @param root
     * @param target
     * @return
     */
    public boolean existI (TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSum = new HashSet<>();
        prefixSum.add(0);
        return helper (root, prefixSum, 0, target);
    }

    private boolean helper (TreeNode root, Set<Integer> prefixSum, int prevSum, int target) {
        prevSum += root.key;
        if (prefixSum.contains(prevSum - target)) {
            return true;
        }
        boolean needRemove = prefixSum.add(prevSum);
        if (root.left != null && helper(root.left, prefixSum, prevSum, target)) {
            return true;
        }
        if (root.right != null && helper(root.right, prefixSum, prevSum, target)) {
            return true;
        }
        if (needRemove) {
            prefixSum.remove(prevSum);
        }
        return false;
    }

    // recursive way
    public boolean exist (TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return findPathI (root, target) || exist(root.left, target) || exist(root.right, target);
    }

    private boolean findPathI (TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (target == root.key) {
            return true;
        }
        return findPathI(root.left, target - root.key)
                || findPathI(root.right, target - root.key);
    }


    // find length  recursive way
    public int pathSum (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int findPath (TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (sum == root.key) {
            res++;
        }
        res += findPath(root.left, sum - root.key);
        res += findPath(root.right, sum - root.key);
        return res;
    }
}
