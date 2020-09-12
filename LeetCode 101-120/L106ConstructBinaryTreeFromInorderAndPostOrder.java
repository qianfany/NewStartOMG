import java.util.HashMap;
import java.util.Map;

public class L106ConstructBinaryTreeFromInorderAndPostOrder {
    /**
     *    Traversing and construct the binary Tree using postOrder and inOrder
     *     the postOrder is [left][right][root]
     *     from the PostOrder, we know the root of the binary tree at the end
     *     the inorder is [left][root][right]
     *     when we know the root, we actually know the boundary of the left/right subtree
     *     the target is actually the root, we are using inOrder to identify the boundary
     *     of the left/right subtree
     *                                     10
     *                                  /      \
     *                                 5       15
     *                              /    \    /    \
     *                             2      7   12    20
     *    InOrder       2       5       7       10      12      15      20
     *    PostOrder     2       7       5       12      20      15      10
     *
     *                  2   5   7       10      12  15  20
     *                  2   7   5       10      12  20  15
     *
     */
    public TreeNode buildTree (int[] inorder, int[] postorder) {
        Map<Integer, Integer> inIndex = indexMap (inorder);
        return helper(postorder, inIndex, 0, inorder.length - 1, 0,
                postorder.length - 1);
    }

    private Map<Integer, Integer> indexMap (int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        // key = value of TreeNode, value = index of the TreeNode value
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;
    }

    private TreeNode helper (int[] post, Map<Integer, Integer> inIndex, int inLeft, int inRight,
                             int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(post[postRight]);
        int inMid = inIndex.get(root.key);
        root.left = helper(post, inIndex, inLeft, inMid - 1, postLeft,
                postLeft + inMid - inLeft - 1);
        root.right = helper(post, inIndex, inMid + 1, inRight,
                postRight + inMid - inRight, postRight -1);
        return root;
    }

    public static void main (String[] args) {
        L106ConstructBinaryTreeFromInorderAndPostOrder sol = new L106ConstructBinaryTreeFromInorderAndPostOrder();
        int[] inorder = {2, 5, 7, 10, 12, 15, 20};
        int[] postorder = {2, 7, 5, 12, 20, 15, 10};
        sol.buildTree(inorder, postorder);
    }
}
