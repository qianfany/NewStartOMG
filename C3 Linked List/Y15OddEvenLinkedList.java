
public class Y15OddEvenLinkedList {
    /**
     * Do it inplace
     * 		1  →   2  →   3  →   4  →   5  →   NULL
     * head 	    →    1
     * EvenHead             even2
     * 1.next = even2.next
     * odd = odd.next
     * 		1  →   2  →   3  →   4  →   5  →   NULL
     * head 	    →    	1  →   3        odd
     * EvenHead              even2
     * 2.next  = odd.next
     * even = even.next
     *
     * termination condition:  even == null || even.next == null
     * odd and even not only serve as the tail pointers but also act as the iterator of the original list,
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList (ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
