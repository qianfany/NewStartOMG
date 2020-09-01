import java.util.HashMap;
import java.util.Map;

public class S6MReconstructBinaryTreeWithPreOrderAndInOrder {
    /*
    Traversing and construct the binary Tree using preOrder and inOrder
    the preOrder is [root][left][right]
    from the preOrder, we know the root of the binary tree
    the inorder is [left][root][right]
    when we know the root, we actually know the boundary of the left/right subtree
    the target is actually the root, we are using inOrder to identify the boundary
    of the left subtree
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

     */
    public TreeNode reconstruct (int[] inOrder, int[] preOrder) {
        int[] preIndex = new int[] {0};
        int[] inIndex = new int[] {0};
        return helper (preOrder, inOrder, preIndex, inIndex, Integer.MAX_VALUE);
    }

    private TreeNode helper (int[] pre, int[] in, int[] preIndex, int[] inIndex, int target) {
        if (inIndex[0] >= in.length || in[inIndex[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex[0]]);
        preIndex[0]++;
        root.left = helper(pre, in, preIndex, inIndex, root.key);
        inIndex[0]++;
        root.right = helper(pre, in, preIndex, inIndex, target);
        return root;
    }
    /*
    solution 2: utilize the inorder sequence to determine the size of left/right subtrees
     */

    public TreeNode reconstructI (int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> inIndex = indexMap(inOrder);
        return helper(preOrder, inIndex, 0, inOrder.length - 1, 0, preOrder.length - 1);
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





    public static void main (String[] args) {
        int[] pre = {10, 5, 2, 7, 15, 12, 20};
        int[] in = {2, 5, 7, 10, 12, 15, 20};
        S6MReconstructBinaryTreeWithPreOrderAndInOrder sol = new S6MReconstructBinaryTreeWithPreOrderAndInOrder();
        sol.reconstruct(in, pre);
    }


}
