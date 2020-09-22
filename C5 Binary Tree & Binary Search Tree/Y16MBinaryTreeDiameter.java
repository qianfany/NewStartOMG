public class Y16MBinaryTreeDiameter {
    /**
     *  calculate the depth of a node in
     *  max(depth of node.left, depth of node.right) + 1
     *  search each node and remember the highest number of nodes
     *  used in some path.
     * @param root
     * @return
     */
    public int diameter (TreeNode root) {
        int[] max = new int[] {0};
        helper(root, max);
        return max[0];
    }

    private int helper (TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftDepth = helper(root.left, max);
        int rightDepth = helper(root.right, max);

        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], leftDepth + rightDepth + 1);
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return root.left == null ? rightDepth + 1 : leftDepth + 1;
    }
    //  time O(N)       Space:  O(N)
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameter = height(root.left) + height(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(diameter, Math.max(left, right)) ;
    }

    private int height (TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main (String[] args) {
        Y16MBinaryTreeDiameter sol = new Y16MBinaryTreeDiameter();
        TreeNode root = new TreeNode(5);
        TreeNode r2 = new TreeNode(2);
        TreeNode r11 = new TreeNode(11);
        TreeNode r6 = new TreeNode(6);
        TreeNode r14 = new TreeNode(14);
        root.left = r2;
        root.right = r11;
        r11.left = r6;
        r11.right = r14;
        System.out.print(sol.diameter(root));
    }
}
