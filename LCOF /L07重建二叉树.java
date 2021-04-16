import java.util.HashMap;
import java.util.Map;

public class L07重建二叉树 {
    /*
    中序遍历  左中右
    前序遍历  中左右

    前序遍历的第一个就是头，通过中序遍历确定头两边的树的分布，依次分
                    3
                  /   \
                 9     20
                      /   \
                    15     7
     */
    public TreeNode buildTree (int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = indexMap(inorder);
        return helper(preorder, indexMap, 0, preorder.length - 1,
                0, inorder.length - 1);
    }

    private Map<Integer, Integer> indexMap (int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return map;
    }

    private TreeNode helper (int[] pre, Map<Integer, Integer> inIndex,
                             int preLeft, int preRight, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int inMid = inIndex.get(root.key);
        root.left = helper(pre, inIndex, preLeft + 1, preLeft + inMid - inLeft,
                inLeft, inMid - 1);
        root.right = helper(pre, inIndex, preRight + inMid - inRight + 1, preRight,
                inMid + 1, inRight);
        return root;
    }
}
