import java.util.*;

public class L501FindModeBinarySearchTree extends BaseObject{

    public int[] findMode(TreeNode root) {
        int prev = Integer.MIN_VALUE;
        int counter = 1;
        int maxCount = 1;
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                int value = cur.val;
                if (prev == value) {
                    counter++;
                } else {
                    counter = 1;
                }
                if (counter == maxCount) {
                    list.add(value);
                } else if (counter > maxCount) {
                    list.clear();
                    list.add(value);
                    maxCount = counter;
                }

                prev = value;
                cur = cur.right;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int min = Integer.MIN_VALUE;
        TreeNode tree = new TreeNode(1);

        L501FindModeBinarySearchTree sol = new L501FindModeBinarySearchTree();
        System.out.println(Arrays.toString(sol.findMode(tree)));
    }
}
