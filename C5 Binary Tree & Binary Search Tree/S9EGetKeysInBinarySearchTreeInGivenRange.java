import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    public void rangeInOrder (TreeNode root, int lower, int upper) {
        if (root == null) {
            return;
        }
        if (root.key > lower) {
            rangeInOrder(root.left, lower, upper);
        }
        if (root.key >= lower && root.key <= upper) {
            System.out.print(root.key);
        }
        if (root.key < upper) {
            rangeInOrder(root.right, lower, upper);
        }
    }

    public List<Integer> getRangeI (TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pollFirst();
                if (cur.key > max) {
                    break;
                }
                if (cur.key >= min && cur.key <= max) {
                    list.add(cur.key);
                }
                cur = cur.right;
            }
        }
        return list;
    }
}
