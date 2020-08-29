public class S5MStoreNumberOfNodesInLeftSubtree {

    public class TreeNodeLeft {
        public int key;
        public TreeNodeLeft left;
        public TreeNodeLeft right;
        public int numNodesLeft;
        public TreeNodeLeft (int key) {
            this.key = key;
        }
    }
    /*
    1. The total number of nodes in my left subtree
    2. The total number of nodes in my right subtree

    current layer
        check if |(1) - (2)| > globalMax
            update globalMax and solution
    What do you want to report to your parent
        return (1) + (2) + 1

     */

    public void numNodesLeft (TreeNodeLeft root) {
        numNodes(root);
    }

    private int numNodes (TreeNodeLeft root) {
        if (root == null) {
            return 0;
        }
        int leftNum = numNodes(root.left);
        int rightNum = numNodes(root.right);
        root.numNodesLeft = leftNum;
        return leftNum + rightNum + 1;
    }
}
