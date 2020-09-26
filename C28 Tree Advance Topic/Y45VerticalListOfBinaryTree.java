import java.util.*;

public class Y45VerticalListOfBinaryTree {
    class Node {
        TreeNode root;
        int col;
        public Node (TreeNode root, int col) {
            this.root = root;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalPrint (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        Map<Integer, List<Node>> map = new HashMap<>();
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            min = Math.min(min, cur.col);
            max = Math.max(max, cur.col);

            if (!map.containsKey(cur.col)) {
                map.put(cur.col, new ArrayList<>());
            }
            map.get(cur.col).add(cur);

            if (cur.root.left != null) {
                queue.offer(new Node(cur.root.left, cur.col - 1));
            }
            if (cur.root.right != null) {
                queue.offer(new Node(cur.root.right, cur.col + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < map.get(i).size(); j++) {
                list.add(map.get(i).get(j).root.key);
            }
            result.add(list);
        }
        return result;
    }
}
