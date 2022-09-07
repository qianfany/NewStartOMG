public class L206ReverseLinkedList extends BaseObject{

    /*
                1 -> 2 -> 3 -> 4 -> 5 -> null
            p   h    n
        null <- 1 <- 2
                p    h    n
                                    p    h
     Time:  O(n)
     Space: O(1)
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
        1 -> 2 -> 3 -> 4 -> 5 -> null

        base case:  head == null or head.next == null return head
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

    public static void main(String[] args) {
        L206ReverseLinkedList sol = new L206ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        sol.reverse(head);

    }
}
