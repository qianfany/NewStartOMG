public class JZ61SerializeDeserializeBinaryTree {
    /*
    use recursion
    or use stack
     */
    private int index = -1;
    public String Serialize (TreeNode root) {
        // preOrder Traversal
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.key + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public TreeNode Deserialize (String str) {
        index++;
        int length = str.length();
        if (index >= length) {
            return null;
        }
        String[] array = str.split(",");
        TreeNode node = null;
        if (!array[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(array[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
