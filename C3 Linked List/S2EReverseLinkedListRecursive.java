public class S2EReverseLinkedListRecursive {
    /*
        1 -> 2 -> 3 -> 4 -> 5 -> null

        base case:  head == null head.next == null return head
        sub-problem: node 2 -- tail node then connect the first node with the recursive rule
        recursive rule:
        new head = reverse (head.next);
        Post processing: head.next.next = head
                         head.next = null
                         return newHead
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
