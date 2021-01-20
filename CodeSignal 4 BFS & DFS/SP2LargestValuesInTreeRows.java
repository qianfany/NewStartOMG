import java.util.*;

public class SP2LargestValuesInTreeRows {

    public int[] largestValuesInTreeRows (Tree<Integer> t) {
        List<Integer> result = new ArrayList<>();
        if (t == null) {
            return new int[0];
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(t);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmpMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Tree<Integer> cur = queue.poll();
                if (cur.value > tmpMax) {
                    tmpMax = cur.value;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(tmpMax);
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
