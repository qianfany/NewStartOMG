public class L19RemoveNthNodeFromEndToList {
    /*
    two pointers:
    maintain a dummy node
    fast pointer slow pointer
    let fast pointer move n nodes first
    then slow and fast starts together to move until fast moved to end
    do remove operation

    Time:   O(n)
    Space:  O(1)

     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
