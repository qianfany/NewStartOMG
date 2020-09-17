public class CP8DeleteFromBST {

    public TreeNode deleteFromBST (TreeNode t, int[] queries) {
        for (int num : queries) {
            deleteTree(t, num);
        }
        return t;
    }

    /*
Delete 8
case 1. the node to be deleted has no children
        3               3
      /   \           /
     2     8         2

case 2. the node to be deleted has no children
        3               3
      /   \           /   \
     2     8         2     10
            \
             10
case 3. the node to be deleted has no left child
        3               3
      /    \          /   \
     2      8        2     6
           /
          6
 case 4. the node deleted has both left and right child.
 we need to move some nodes from left/right subtree to
 replace it
 case 4.1 node.right does not have left child, meaning
 itself is the smallest node. in this case, we just move
 node.right up
        3                   3
      /    \              /   \
     2      8            2     10
           /  \               /   \
          6    10            6     12
                 \
                 12
 case 4.2 node.right has left child, we need to find the
 smallest node, and move it up
        3                           3
      /    \                      /    \
     2      8                    2      9
          /    \                      /   \
         6      12                   6     12
               /   \                      /   \
              11    14                   11    14
             /                          /
             9                         10
              \
              10
    Time: O(h)
    Space: O(h)
 */
    public TreeNode deleteTree (TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key > key) {
            root.left = deleteTree(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteTree(root.right, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        // case 4.1
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        // case 4.2
        TreeNode smallest = deleteSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode deleteSmallest (TreeNode cur) {
        TreeNode prev = cur;
        cur = cur.left;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = prev.left.right;
        return cur;
    }
}
