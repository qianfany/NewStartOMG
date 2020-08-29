import java.util.ArrayList;
import java.util.List;

public class S9EGetKeysInBinarySearchTreeInGivenRange {
    /*
    determine whether we need to go left
    only if (root.value > lower_bound) do we need to go left
    determine whether we need to go right
    only if (root.value < upper_bound) do we need to go right

    Optimization: Pruning
    Time: O(n) worst case
    better answer: O(height + # of nodes in the range of [min, max])
    Space: O(height)
     */
    public List<Integer> getRange (TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        getRange(root, min, max, list);
        return list;
    }

    private void getRange (TreeNode root, int min, int max, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.key > min) {
            getRange(root.left, min, max, list);
        }
        if (root.key >= min && root.key <= max) {
            list.add(root.key);
        }
        if (root.key < max) {
            getRange(root.right, min, max, list);
        }
    }
}
