import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L95UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees (int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTree(1, n);
    }
    public List<TreeNode> genTree (int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTree(start, i - 1);
            right = genTree(i + 1, end);
            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
