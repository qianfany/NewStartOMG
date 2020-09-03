import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S14MInOrderTraversalOfBinaryTreeIterative {
    /*
    root is the top element in the stack, use a helper node to store the next
    "visiting" node and subtree
    1. when helper node is not null, we should traverse the subtree, so we push
    helper and we go left
    2. when helper is null, which means the left subtree of the root is finished,
    the root is the top element in the stack
    we can print the top, and let helper = top.right
    3. do 1 and 2 until helper is null and there is no nodes left in the stack

                                5
                           /          \
                          2            8
                       /     \
                      1       3
     5                                      stack               print
     5 -> 5 !null  helper = 5.left           {5}
     2 -> 2 !null  helper = 2.left           {5, 2}
     1 -> 1 !null  helper = 1.left           {5, 2, 1}
     null, helper = 1.right                  {5, 2}               1
     null, helper = 2.right                  {5}                  2
     3 -> 3 !null  helper = 3.left           {5, 3}
     null, helper = 3.right                  {5}                  3
     null, helper = 5.right                  {}                   5
     8 -> 8 !null   helper = 8.left          {8}
     null, helper = 8.right                  {}                   8
     null

     Time: O(n)
     Space: O(n)
     */
    public List<Integer> inOrder (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pollFirst();
                list.add(cur.key);
                cur = cur.right;
            }
        }
        return list;
    }
}
