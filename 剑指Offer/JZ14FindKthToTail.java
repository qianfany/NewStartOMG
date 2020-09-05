public class JZ14FindKthToTail {
    /*
    two pointers:
    fast pointer
    slow pointer
    let fast pointer move k nodes,
    then slow and fast starts together to move until fast moved to end

    Time: O(n)
    Space: O(1)
     */
    public ListNode FindKthToTail (ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k >0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
