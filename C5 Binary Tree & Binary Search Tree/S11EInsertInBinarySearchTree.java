import java.time.temporal.Temporal;

public class S11EInsertInBinarySearchTree {
    /*
    Time: O(h)
    Space: O(h)

    root.left = insert (root.left, key)
    root.right = insert (root.right, key)
     */
    public TreeNode insert (TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.key) {
            root.left = insert (root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    //tail recursion, remove redundant operation
    public TreeNode insertI (TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        helper (root, target);
        return root;
    }

    private void helper (TreeNode root, int target) {
        if (target == root.key) {
            return;
        }
        else if (target < root.key) {
            if (root.left == null) {
                root.left = new TreeNode(target);
            } else {
                helper(root.left, target);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(target);
            } else {
                helper(root.right, target);
            }
        }
    }

    public TreeNode insertII (TreeNode root, int target) {
        TreeNode newNode = new TreeNode(target);
        if (root == null) {
            return newNode;
        }
        TreeNode current = root;
        while (current.key != target) {
            if (current.key > target) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = newNode;
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = newNode;
                    break;
                }
            }
        }
        return root;
    }



    public static void main (String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l3 = new TreeNode(3);
        TreeNode l8 = new TreeNode(8);
        TreeNode l1 = new TreeNode(1);
        TreeNode l4 = new TreeNode(4);
        root.left = l3;
        root.right = l8;
        l3.left = l1;
        l3.right = l4;
        S11EInsertInBinarySearchTree sol = new S11EInsertInBinarySearchTree();
        System.out.println(sol.insert(root, 11));
    }
}
