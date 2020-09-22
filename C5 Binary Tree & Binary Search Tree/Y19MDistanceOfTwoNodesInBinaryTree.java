public class Y19MDistanceOfTwoNodesInBinaryTree {
    /**
     * step 1: find the lowest common ancestor
     * step 2: find the distance between LCA to 2 given nodes
     * Time: O(N)
     * Space: O(N)
     * @param root
     * @param k1
     * @param k2
     * @return
     */
    public int distance (TreeNode root, int k1, int k2) {
        TreeNode LCATree = lac(root, k1, k2);
        if (LCATree.key == k1) {
            return pathDis(LCATree, k2);
        } else if (LCATree.key == k2) {
            return pathDis(LCATree, k1);
        }
        return pathDis(LCATree, k1) + pathDis(LCATree, k2);
    }

    private int pathDis (TreeNode root, int target) {
        if (root == null) {
            return -1;
        }
        int dis = -1;
        if ((root.key == target) || (dis = pathDis(root.left, target)) >= 0
        || (dis = pathDis(root.right, target)) >= 0) {
            return dis + 1;
        }
        return dis;
    }

    private TreeNode lac (TreeNode root, int k1, int k2) {
        if (root == null) {
            return null;
        }
        if (root.key == k1 || root.key == k2) {
            return root;
        }
        TreeNode left = lac(root.left, k1, k2);
        TreeNode right = lac(root.right, k1, k2);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
