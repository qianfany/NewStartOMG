public class Y21EBinaryTreePathSumToTargetI {
    /**
    base case:  root == null    return false
     sub-problem exist (root.left, target - root.key) || exist(root.right, target - root.key)
     if target == 0 and its the leaf node   return true
     Time:  O(N)            Space: O(H)
     */
    public boolean exist (TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        target = target - root.key;
        if (target == 0 && root.left == null && root.right == null) {
            return true;
        }
        return exist(root.left, target) || exist(root.right, target);
    }
}
