public class S3ReverseLinkedListInPairs {
    /*
    N1 → N2 → N3 → N4 → N5 → N6 → null
    N2 → N1 → N4 → N3 → N6 → N5 → null
                ___________________________
    N1 → N2 →| N3 → N4 → N5 → N6 → null	  |
                ------------------------------
    N1 ←  N2   | N3 ←  N4 → N5 → N6 → null	  |
    |	        -------------------------------
    -------------------->
    current → next = newHead of the sub-problem
    next → next = curr 		// next becomes the new Head
    so, if we resolve the sub-problem first, then we just need to perform
    (1) and (2) to solve the whole problem
    Time: O(n)			Space: O(n)
     */

    public ListNode reverseInPairs (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = reverseInPairs(head.next.next);
        next.next = head;
        return next;
    }
/*
    sol 2. iterative way
        N1 → N2 → N3 → N4 → N5 → N6 → null
    N2 → N1 → N4 → N3 → N6 → N5 → null

              __________________________
    N1 → N2 →| N3 → N4 → N5 → N6 → null	|
              ---------------------------
    ------(4)---------|
    d →     N1 ←(3) N2(1)    N3
            |____(2)_________|
        Time: O(n)			Space: O(1)
 */
    public ListNode reverseInPairsII(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
