public class S3ReverseLinkedListInPairs {
    /*
    1 -> 2 -> 3 -> 4 -> 5 -> NULL
    output:
    2 -> 1 -> 4 -> 3 -> 5 -> NULL
    cur -> next = New head of subProblem
    next -> next = cur  // "next" becomes the new head
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
