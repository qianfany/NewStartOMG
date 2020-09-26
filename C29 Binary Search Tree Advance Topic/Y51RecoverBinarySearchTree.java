import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Y51RecoverBinarySearchTree {

    public TreeNode recover (TreeNode root) {
        Map<TreeNode, Integer> toInOrderIndex = new HashMap<>();
        List<TreeNode> inOrderRes = new ArrayList<>();
        inOrderTraversal(root, toInOrderIndex, inOrderRes);
        toSort(inOrderRes);
        return reconstruct(root, toInOrderIndex, inOrderRes);
    }

    private TreeNode reconstruct (TreeNode cur, Map<TreeNode, Integer> indices, List<TreeNode> inOrder) {
        if (cur == null) return cur;
        TreeNode left = reconstruct(cur.left, indices, inOrder);
        TreeNode right = reconstruct(cur.right, indices, inOrder);
        TreeNode newCur = inOrder.get(indices.get(cur));
        if (newCur != cur) {
            newCur = shallowCopy(newCur);
            newCur.left = left;
            newCur.right = right;
            return newCur;
        } else {
            cur.left = left;
            cur.right = right;
            return cur;
        }
    }

    private TreeNode shallowCopy (TreeNode ori) {
        return new TreeNode(ori.key);
    }

    private void inOrderTraversal (TreeNode cur, Map<TreeNode, Integer> indices, List<TreeNode> res) {
        if (cur == null) {
            return;
        }
        inOrderTraversal(cur.left, indices, res);
        int index = res.size();
        indices.put(cur, index);
        res.add(cur);
        inOrderTraversal(cur.right, indices, res);
    }

    private void toSort (List<TreeNode> inOrder) {
        int left = 0;
        int right = inOrder.size() - 1;
        while (left < right && inOrder.get(left).key < inOrder.get(left + 1).key) {
            left++;
        }
        while (left < right && inOrder.get(right).key > inOrder.get(right - 1).key) {
            right--;
        }
        swap(inOrder, left, right);
    }

    private void swap (List<TreeNode> src, int left, int right) {
        TreeNode temp = src.get(left);
        src.set(left, src.get(right));
        src.set(right, temp);
    }
}
