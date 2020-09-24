import java.util.*;

public class Y30ReConstructFromLevelOrderInOrder {

    public TreeNode reconstruct (int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        List<Integer> levelList = new LinkedList<>();
        for (int num: levelOrder) {
            levelList.add(num);
        }
        return helper (levelList, inMap);
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
