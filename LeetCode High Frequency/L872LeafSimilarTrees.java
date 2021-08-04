import java.util.ArrayList;
import java.util.List;

public class L872LeafSimilarTrees {

    public boolean leafSimilar (TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        if (root1 != null) {
            traverse(root1, list1);
        }
        List<Integer> list2 = new ArrayList<>();
        if (root2 != null) {
            traverse(root2, list2);
        }
        return list1.equals(list2);
    }

    private void traverse (TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.key);
        } else {
            if (node.left != null) {
                traverse(node.left, list);
            }
            if (node.right != null) {
                traverse(node.right, list);
            }
        }
    }
}
