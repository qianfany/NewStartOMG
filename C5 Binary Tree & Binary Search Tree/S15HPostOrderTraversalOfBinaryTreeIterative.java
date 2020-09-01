import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S15HPostOrderTraversalOfBinaryTreeIterative {
    /*
    post order traverse has the properties of [left][right][root]
    pre order traverse with slight modification has the properties of [root][right][left]
    can be down with the modification of the iterative preOrder Traversal then reverse
    However, everything will be store in memory before we can get the whole
    post order traversal
    Solution:
    maintain a previous Node, to record the previous visiting node on the traversing
    path, so that we know what the direction we are taking now and what is the
    direction we are taking next, maintain a stack to track previous nodes

    - root = stack.top
    if previous is null -> going down (left subtree has priority)
    if previous is current parent -> going down (left subtree has priority)
    if previous == current.left -> left subtree finished, going current.right
    if previous == current.right -> right subtree finished, pop current, going up

                                5
                           /          \
                          2            8
                       /     \
                      1       3

    previous                   stack        print -> left and right subtree both finished
    null                        {5}
    5                           {5, 2}
    2                           {5, 2, 1}                           1
    1                           {5, 2}
    2                           {5, 2, 3}                           3
    3                           {5, 2}                              2
    2                           {5}
    5                           {5, 8}                              8
    8                           {5}                                 5
    5                           {}
     */

    public List<Integer> postOrder (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.pollFirst();
                    result.add(cur.key);
                }
            }
            else if (prev == cur.right || prev == cur.left && cur.right == null) {
                stack.pollFirst();
                result.add(cur.key);
            } else {
                stack.offerFirst(cur.right);
            }
            prev = cur;
        }
        return result;
    }

}
