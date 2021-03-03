public class L109ConvertSortedListToBST {
    /*
      PreOrder Traversal to whole list, find the mid point
      if left == right, then there is no elements available
      root = TreeNode middle
      compute recursively left and right subtrees root.left = helper (left, p - 1)
      root.right = helper (p+1, right)
      Time: O(n log n)
      Space: O(n)
      @param head
      @return
     */
    public TreeNode sortedListToBST (ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    private TreeNode toBST (ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.value);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }
}
