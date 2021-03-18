import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L297SerializeDeserializeBinaryTree {

    public String serialize (TreeNode root) {
        // preOrder Traversal
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("null,");
            return sb.toString();
        }
        sb.append(root.key + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public TreeNode deserialize (String data) {
        Deque<String> nodes = new ArrayDeque<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
