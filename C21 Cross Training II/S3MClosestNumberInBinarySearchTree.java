public class S3MClosestNumberInBinarySearchTree {
    /*
                            10
                        5       15
                     2     7   12    20
     Data Structure
     Maintain a global min_diff
     Maintain a solution node, which achieves the min_diff
     Algorithm:
     Initialize: result = root.key
     In each step:
     case 1: cur.key == target, solution = cur.key return
        if abs(root.key - target) < abs(result - target)
            update result
        case 2: root.key < target   go right
        case 3: root.key > target   go left
     */
    public int closest (TreeNode root, int target) {
        int result = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            } else {
                if (Math.abs(root.key - target) < Math.abs(result - target)) {
                    result = root.key;
                }
                if (root.key < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return result;
    }
}
