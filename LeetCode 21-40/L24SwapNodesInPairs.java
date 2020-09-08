public class L24SwapNodesInPairs {
    /*
    1 -> 2 -> 3 -> 4 -> 5 -> NULL
            ______________________
    1 <- 2  | 3 <- 4  .... <- NodeN
            ----------------------
    |______________|

    1 -> 4
    2 -> 1
    4 -> 3
    2 becomes head
    output:
    2 -> 1 -> 4 -> 3 -> 5 -> NULL
    cur -> next = New head of subProblem
    next -> next = cur  // "next" becomes the new head
     */
    // Time: O(n)          Space: O(n)
    public ListNode swapPairs (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    // time: O(n)           space: O(1)
    public ListNode swapPairsIterative (ListNode head) {
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
