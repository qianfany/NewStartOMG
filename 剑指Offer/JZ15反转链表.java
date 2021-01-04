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

    /*
    sol.2 recursive way
    1   ->   2   ->   3   ->    4   ->    5   ->    null
    base case: head == null  || head.next == null  	return head
    sub-Problem: 	node 2  ---- tail node then connect the first node with the recursive rule
    recursive rule:   new head = reverse (head.next)
    post processing:  	head.next.next = head	head.next = null	return newHead
    Time: O(N)
    Space: O(N)
     */

    public ListNode reverseRecursion (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
