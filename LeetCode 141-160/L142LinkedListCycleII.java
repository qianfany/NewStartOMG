public class L142LinkedListCycleII {
    /*
    ____________________            Set the distance from start point to cycle = L
                /       \           Set the distance of cycle = C
               /         \
               |          | s f       s = L + 1/4C  f = L + 1/4C + C    2L + 1/2C = L + 5/4C
                \        /           2s = f        L + 1/4 C = C  L = 3/4 C which is the remaining distance
                 \______/
                                     set fast pointer back to the start, when met, is the start of the pointer

    */
    public ListNode detectCycle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
