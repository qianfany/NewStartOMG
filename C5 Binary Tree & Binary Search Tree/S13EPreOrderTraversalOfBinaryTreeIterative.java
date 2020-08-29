import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S13EPreOrderTraversalOfBinaryTreeIterative {
    /*
    We always print root first, then root can be eliminated from stack
    We traverse left sub first, so the right sub should be retained in the stack
    before the left sub is done

            5
         /     \
        2       8
       / \        \
      1   3        9

      Stack
      push 5
      {5}   -> pop 5  push 8 & 2
      {8, 2} -> pop 2  push 3 & 1
      {8, 3, 1} -> pop 1
      {8, 3} -> pop 3
      {8} -> pop 8  push 9
      {9} -> pop 9
      {}

     */
    public List<Integer> preOrder (TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            preOrder.add(cur.key);
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
        return preOrder;
    }
}
