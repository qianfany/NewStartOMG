import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S8HReconstructBinaryTreeWithLevelOrderAndInOrder {
    /*
                            20
                         /      \
                        8        22
                      /   \
                     4     12
                          /   \
                         10    14
     index = 0  1   2   3   4   5   6
     in      4  8   10  12  14  20  22
     level   20 8   22  4   12  10  14

     Step 1: Pick the first element from the level-order, find the index of root in the inorder
     sequence. Thus, the in-order sequence can be divided into two parts
     Step 2: How to divide the level-order into two parts
             we need to build the level-order for the left subtree and for the right subtree
             Iterate through each element in the level-order, and check if it belongs to the
             left of the right subtree, using indexMap:
                case 1: if indexMap[x] < indexMap[root]: add x to left level-order
                case 2: if indexMap[x] > indexMap[root]: add x to right level-order
    Time: O(n^2)
    Space: O(n^2)
     */
    public TreeNode reconstruct (int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> inMap =new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        List<Integer> lList = new ArrayList<>();
        for (int num : levelOrder) {
            lList.add(num);
        }
        return helper (lList, inMap);
    }

    private TreeNode helper (List<Integer> level, Map<Integer, Integer> inMap) {
        if (level.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(level.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : level) {
            if (inMap.get(num) < inMap.get(root.key)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        root.left = helper(left, inMap);
        root.right = helper(right, inMap);
        return root;
    }
}
