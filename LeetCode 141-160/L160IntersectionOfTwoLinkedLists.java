public class L160IntersectionOfTwoLinkedLists {
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
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;
                }
                if (p2 == null) {
                    p2 = headA;
                }
            }
        }
        return p1;
    }
}
