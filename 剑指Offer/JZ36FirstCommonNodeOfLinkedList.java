public class JZ36FirstCommonNodeOfLinkedList {
    /*
    0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
    a -> b -> 4 -> 5 -> null
    connect them together, first common point is shown

    0 -> 1 -> 2 -> 3 -> 4 -> 5 -> a -> b -> 4 -> 5 -> null
                                            !
    a -> b -> 4 -> 5 -> 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
                                            !
    Time: O(m + n)
    Space: O(1)
     */
    public ListNode common (ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) p1 = head2;
                if (p2 == null) p2 = head1;
            }
        }
        return p1;
    }
}
