public class L82RemoveDuplicatesFromSortedListII {
    /*
        1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
                            cur
   d -> 1 -> 2 -> 4
              -> 5

        initialize two pointer at start,

     */
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.value == cur.next.value) {
                cur = cur.next;
            }
            if (prev.next == cur) {
                prev = prev.next;
                // cur value is distinct, move pre to next node
            }
            else {
                prev.next = cur.next;
                // skip duplicates but prev pointer no move
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
