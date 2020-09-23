import java.util.ArrayList;
import java.util.List;

public class L113PathSumII {
    /*
    Depth First search
    findPath: go from root to find the sum path
    condition: root is the leaf and sum = root.key
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

    public List<List<Integer>> pathSumII (TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, sum, list, res);
        return res;
    }

    public void helper (TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        list.add(root.key);
        sum -= root.key;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        helper(root.left, sum, list, res);
        helper(root.right, sum, list, res);
        list.remove(list.size() - 1);   // backtracking
    }
}
