public class JZ56DeleteDuplicationLinkedList {
    /*
    1. dummy node, avoid first == second
    2. fast linear scan to get all duplicate
     */
    public ListNode delete (ListNode pHead) {
        ListNode dummy = new ListNode(0);
        ListNode fast = pHead, slow = dummy;
        slow.next = fast;

        while (fast != null) {
            while (fast.next != null && fast.value == fast.next.value) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = slow.next;
                // no change
            } else {
                slow.next = fast.next;
                fast = fast.next;
                // get to current
            }
        }
        return dummy.next;
    }
}
