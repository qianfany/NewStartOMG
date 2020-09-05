public class JZ15反转链表 {
    /*
                1 -> 2 -> 3 -> 4 -> 5 -> null
            p   h    n
                p    h    n
                                    p    h
     Time:  O(n)
     Space: O(1)
     */
    public ListNode reverse (ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
