public class Y23MLongestAscendingPathBinaryTree {

    public int longest (TreeNode root) {
        if (root == null) return 0;
        return Math.max(longestPath(root.left, root.key, 1),
                longestPath(root.right, root.key, 1));
    }

    private int longestPath (TreeNode root, int target, int count) {
        if (root == null) return 1;
        count = root.key > target ? count+1 : 1;
        int left = longestPath(root.left, root.key, count);
        int right = longestPath(root.right, root.key, count);
        return Math.max(Math.max(left, right), count);
    }

    public static void main (String[] args) {
        Y23MLongestAscendingPathBinaryTree sol = new Y23MLongestAscendingPathBinaryTree();
        TreeNode root = new TreeNode(5);
        TreeNode r2 = new TreeNode(2);
        TreeNode r11 = new TreeNode(11);
        TreeNode r6 = new TreeNode(6);
        TreeNode r14 = new TreeNode(14);
        root.left = r2;
        root.right = r11;
        r11.left = r6;
        r11.right = r14;
        System.out.print(sol.longest(root));
    }
}
