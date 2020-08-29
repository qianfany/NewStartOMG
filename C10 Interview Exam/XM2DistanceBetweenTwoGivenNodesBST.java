public class XM2DistanceBetweenTwoGivenNodesBST {
    /*
    Distance between two given nodes in binary search tree
    Find the Lowest common ancestor, then find the distance between LCA to 2 given nodes
    Time:	O(N)
    Space: O(N)
     */
    public int findDistance (TreeNode root, TreeNode r1, TreeNode r2) {
        TreeNode LowestCA = lac(root, r1, r2);
        // assume r1 r2 are different node
        if (LowestCA.key == r1.key) {
            return pathDis(LowestCA, r2);
        }
        else if (LowestCA.key == r2.key) {
            return pathDis(LowestCA, r1);
        }
        return pathDis(LowestCA, r1) + pathDis(LowestCA, r2);
    }

    private int pathDis (TreeNode root, TreeNode one) {
        if (root == null) {
            return 0;
        }
        if (root.key == one.key) {
            return 0;
        }
        if (root.key > one.key) {
            return pathDis(root.left, one) + 1;
        }
        else {
            return pathDis(root.right, one) + 1;
        }

    }

    private TreeNode lac (TreeNode root, TreeNode r1, TreeNode r2) {
        if (root == null) {
            return null;
        }
        if (root == r1 || root == r2) {
            return root;
        }
        TreeNode left = lac(root.left, r1, r2);
        TreeNode right = lac(root.right, r1, r2);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main (String[] args) {
        XM2DistanceBetweenTwoGivenNodesBST sol = new XM2DistanceBetweenTwoGivenNodesBST();
        TreeNode root = new TreeNode(15);
        TreeNode l5 = new TreeNode(5);
        TreeNode l20 = new TreeNode(20);
        TreeNode l3 = new TreeNode(3);
        TreeNode l10 = new TreeNode(10);
        TreeNode l1 = new TreeNode(1);
        TreeNode l4 = new TreeNode(4);
        TreeNode l8 = new TreeNode(8);
        TreeNode l7 = new TreeNode(7);
        TreeNode l9 = new TreeNode(9);
        root.left = l5;
        root.right = l20;
        l5.left = l3;
        l5.right = l10;
        l3.left = l1;
        l3.right = l4;
        l10.left = l8;
        l8.left = l7;
        l8.right = l9;
        System.out.println(sol.findDistance(root, l1, l9));
    }
}
