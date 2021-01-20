import java.util.*;

public class SP1TraverseTree {

    public int[] traverseTree (Tree<Integer> t) {
        int[] corner = new int[0];
        List<Integer> result = new ArrayList<>();
        if (t == null) {
            return corner;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(t);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tree<Integer> cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                result.add(cur.value);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private class Tree<Integer> {
        Tree(int x) {
            value = x;
        }
        int value;
        Tree<Integer> left;
        Tree<Integer> right;
    }
}
