import java.util.ArrayList;
import java.util.List;

public class L257BinaryTreePaths extends BaseObject {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(Integer.toString(root.val));
            return list;
        }
        for (String s : binaryTreePaths(root.left)) {
            list.add(root.val + "->" + s);
        }
        for (String s : binaryTreePaths(root.right)) {
            list.add(root.val + "->" + s);
        }
        return list;
    }

    public static void main(String[] args) {
        L257BinaryTreePaths sol = new L257BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(sol.binaryTreePaths(root));
    }
}
