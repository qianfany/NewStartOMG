import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Y26ConnectRightPointerToSuccessor {

    public void connect (TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        inOrder(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i).right == null) {
                result.get(i).right = result.get(i + 1);
            }
        }
    }

    private void inOrder (TreeNode curr, List<TreeNode> result) {
        if (curr == null) {
            return;
        }
        inOrder(curr.left, result);
        result.add(curr);
        inOrder(curr.right, result);
    }
}
