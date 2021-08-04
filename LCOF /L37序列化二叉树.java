public class L37序列化二叉树 {

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
    private int index = - 1;
    public TreeNode deserialize (String data) {
        index++;
        int length = data.length();
        if (index >= length) {
            return null;
        }
        String[] array = data.split(",");
        TreeNode node = null;
        if (!array[index].equals("null")) {
            node = new TreeNode(Integer.valueOf(array[index]));
            node.left = deserialize(data);
            node.right = deserialize(data);
        }
        return node;
    }
}
