import java.util.ArrayList;
import java.util.List;

public class Y46BorderViewOfBinaryTree {

    private List<Integer> list = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree (TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.key);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return list;
    }

    private void leftBoundary (TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        list.add(root.key);
        if (root.left == null) {
            leftBoundary(root.right);
        } else {
            leftBoundary(root.left);
        }
    }

    private void rightBoundary (TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return;
        }
        if (root.right == null) {
            rightBoundary(root.left);
        } else {
            rightBoundary(root.right);
        }
        list.add(root.key);
    }

    private void leaves (TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.key);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
