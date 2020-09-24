import java.util.HashMap;
import java.util.Map;

public class Y28ReconstructFromPreOrderInorder {
    /**
     Traversing and construct the binary Tree using preOrder and inOrder
     the preOrder is [root][left][right]
     from the preOrder, we know the root of the binary tree
     the inorder is [left][root][right]
     when we know the root, we actually know the boundary of the left/right subtree
     the target is actually the root, we are using inOrder to identify the boundary
     of the left/right subtree
                                 10
                               /      \
                              5       15
                           /    \    /    \
                         2      7   12    20

     PreOrder     10   5   2   7   15  12  20
     InOrder      2    5   7   10  12  15  20
                  10        5 2 7     15 12 20
                   2 5 7        10     12 15 20

                 5 2 7           15 12 20
                 2 5 7           12 15 20
                 5   2 7         15      12 20
                 2   5   7       12    15    20
     Utilize the inorder sequence to determine the size of left/right subtrees
     Time: O(n)
     Space: O(n)
     put the inOrder array to the indexMap where
     key = value of TreeNode    value = index of treeNode value
     */
    public TreeNode reconstruct (int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> inIndex = indexMap(inOrder);
        return helper(preOrder, inIndex, 0, inOrder.length - 1,
                0, preOrder.length - 1);
    }

    private Map<Integer, Integer> indexMap (int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;
    }

    private TreeNode helper (int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight,
                             int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int inMid = inIndex.get(root.key);
        root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1,
                preLeft + inMid - inLeft);
        root.right = helper(pre, inIndex, inMid + 1, inRight,
                preRight + inMid - inRight + 1, preRight);
        return root;
    }
}
