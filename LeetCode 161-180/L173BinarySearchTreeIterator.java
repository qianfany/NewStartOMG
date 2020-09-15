import java.util.ArrayDeque;
import java.util.Deque;

public class L173BinarySearchTreeIterator {
    private Deque<TreeNode> stack;
    private TreeNode node;

    public L173BinarySearchTreeIterator (TreeNode root) {
        stack = new ArrayDeque<>();
        node = root;
    }

    public int next () {
        while (node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
        node = stack.pollFirst();
        int res = node.key;
        node = node.right;
        return res;
    }

    public boolean hasNext () {
        return !stack.isEmpty() || node != null;
    }
}
