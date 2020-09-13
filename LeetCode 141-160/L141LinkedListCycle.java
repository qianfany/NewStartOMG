public class L141LinkedListCycle {
    /**
    ____________________            Set the distance from start point to cycle = L
                /       \           Set the distance of cycle = C
               /         \
               |          | s f       s = L + 1/4C  f = L + 1/4C + C
                \        /           2s = f        L + 1/4 C = C  L = 3/4 C which is the remaining distance
                 \______/
                                     set fast pointer back to the start, when when met, is the start of the pointer

    */
    public boolean hasCycle (ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
