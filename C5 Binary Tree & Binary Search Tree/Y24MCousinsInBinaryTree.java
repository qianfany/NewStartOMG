import java.util.LinkedList;
import java.util.Queue;

public class Y24MCousinsInBinaryTree {
    /**
     * Define Cousin: two nodes are cousins of each other if they are
     * at same level and have different parents
     *
     * Level-Order traverse, check first if both are not same levels and
     * check their parents
     *
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    public boolean isCousin (TreeNode root, int a, int b) {
      if (root == null) {
          return false;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
          TreeNode parentA = null, parentB = null;
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              TreeNode cur = queue.poll();
              if (cur.left != null) {
                  if (cur.left.key == a) {
                      parentA = cur;
                  } else if (cur.left.key == b) {
                      parentB = cur;
                  }
                  queue.offer(cur.left);
              }
              if (cur.right != null) {
                  if (cur.right.key == a) {
                      parentA = cur;
                  } else if (cur.left.key == b) {
                      parentB = cur;
                  }
                  queue.offer(cur.right);
              }
          }
          if (parentA != null && parentB != null) {
              return parentA != parentB;
          } else if (parentA != null || parentB != null) {
              return false;
          }
      }
      return false;
    }
}
