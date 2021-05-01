public class L24反转链表 {
    /*
    iterative way
            1   ->  2   ->  3   ->  4   ->  5   ->  null
      pre   h       n
            p       h       n
                                            p       h
     */
    public ListNode reverseList (ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    /*
    base case:      head == null || head.next == null       return head
    subProblem:     node 2 ---> tail node
    recursive rule: new head = reverse(head.next)
    Post Process:   connect the first node with the recursive rule
     */

    public ListNode reverse (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
