import java.util.ArrayList;

public class JZ24BinaryTreePathSumToTargetII {
    /*
    Depth First search
    findPath: go from root to find the sum path
    termination condition: root is the leaf and sum = root.key
    go left and go right

                            5
                         /     \
                       7        1
                               /   \
                              6     14
                            /
                           3
        Time: O(n)
        Space: O(n)
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath (TreeNode root, int target) {
        if (root == null) return result;
        list.add(root.key);
        target -= root.key;
        // add to result if sum target and its the leaf node
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        // go left
        FindPath(root.left, target);
        // go right
        FindPath(root.right, target);
        list.remove(list.size() - 1);   // backtrack
        return result;
    }
}
