import java.util.ArrayList;
import java.util.List;

public class L113PathSumII {
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
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum (TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        list.add(root.key);
        sum -= root.key;
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        list.remove(list.size() - 1);   // backtrack
        return result;
    }
}
