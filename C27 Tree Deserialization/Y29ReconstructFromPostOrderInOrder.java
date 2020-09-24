import java.util.HashMap;
import java.util.Map;

public class Y29ReconstructFromPostOrderInOrder {
    /**
    The PostOrder is [left][right][root]
    from the postOrder, we know the root of the binary tree
    The InOrder is [left][root][right]
    when we know the root, we actually know the boundary of the left/right subtree
    the target is actually the root, we are using inOrder properties to identify the boundary of the left/right subtree
                                      10
                                   /      \
                                  5       15
                               /    \     /    \
                             2      7    12    20
    PostOrder	2	7	5	12	20	15	10
    InOrder	    2	5	7	10	12	15	20
                2   7    5  		12   20   15 		10
                2   5    7 		10	12    15    20

                2 7      5		12  20 	   15		10
                2   	5	7	10	12	15	20
         Utilize the inorder sequence to determine the size of left/right subtrees
         Time: O(n)				Space: O(n)
         put the inOrder array to the indexMap where
         key = value of TreeNode    value = index of treeNode value

     */
    public TreeNode reconstruct (int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> inIndex = indexMap(inOrder);
        return helper(postOrder, inIndex, 0, inOrder.length - 1,
                0, postOrder.length - 1);
    }

    private Map<Integer, Integer> indexMap (int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
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
                postRight + inMid - inRight, postRight - 1);
        return root;
    }
}
