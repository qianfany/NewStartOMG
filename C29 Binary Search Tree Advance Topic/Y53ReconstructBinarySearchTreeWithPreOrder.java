import java.util.ArrayDeque;
import java.util.Deque;

public class Y53ReconstructBinarySearchTreeWithPreOrder {

    public TreeNode reconstruct (int[] pre) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(pre[0]);
        stack.offerFirst(root);

        for (int i = 1; i < pre.length; i++) {
            TreeNode node = new TreeNode(pre[i]);
            if (pre[i] < stack.peekFirst().key) {
                stack.peekFirst().left = node;
            } else {
                TreeNode parent = stack.peekFirst();
                while (!stack.isEmpty() && pre[i] > stack.peekFirst().key) {
                    parent = stack.pollFirst();
                }
                parent.right = node;
            }
            stack.offerFirst(node);
        }
        return root;
    }

    public TreeNode reconstructR (int[] pre) {
        int[] index = new int[] {0};
        return helper(pre, index, Integer.MAX_VALUE);
    }

    private TreeNode helper (int[] pre, int[] index, int max) {
        if (index[0] > pre.length - 1 || pre[index[0]] >= max) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index[0]++]);
        root.left = helper(pre, index, root.key);
        root.right = helper(pre, index, max);
        return root;
    }
}
