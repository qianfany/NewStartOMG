import java.util.*;

public class Y47DiagonalSumOfABinaryTree {
    class Node {
        TreeNode root;
        int verticalD;
        public Node (TreeNode root, int verticalD) {
            this.root = root;
            this.verticalD = verticalD;
        }
    }
    public List<Integer> diagonalSum (TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(new Node(root, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int verticalD = cur.verticalD;

            while (cur != null) {
                int prevSum = map.getOrDefault(verticalD, 0);
                map.put(verticalD, prevSum + cur.root.key);
                if (cur.root.left != null) {
                    queue.offer(new Node(cur.root.left, cur.verticalD + 1));
                }
                if (cur.root.right == null) {
                    cur = null;
                } else {
                    cur = new Node(cur.root.right, verticalD);
                }
            }
        }
        List<Integer> res = new ArrayList<>(map.values());
        return res;
    }

    public static void main(String[] args)
    {
        Y47DiagonalSumOfABinaryTree sol = new Y47DiagonalSumOfABinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);
        System.out.print(sol.diagonalSum(root));
    }

}
