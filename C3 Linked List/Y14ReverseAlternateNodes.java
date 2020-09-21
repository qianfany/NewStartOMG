public class Y14ReverseAlternateNodes {
    /**
     * input: 		1 →  2  →   3  →   4  →  5 →  6
     * Output: 	    1 →  3  →   5  →   6  →  4 →  2
     * Maintain two linked lists, one list for all odd position and the other for all even position
     * reverse the second half and connect together
     * 1 -> 3 -> 5
     * 2 -> 4 -> 6	6 -> 4 -> 2
     * 1 -> 3 -> 5 -> 6 -> 4 -> 2
     * Time: 		O(n)			Space: 	O(1)
     * @param head
     * @return
     */
    public ListNode reverseAlternate (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode oddH = new ListNode(0);
        ListNode odd = oddH;
        ListNode evenH = new ListNode(0);
        ListNode even = evenH;
        while (cur != null && cur.next != null) {
            odd.next = cur;
            even.next = cur.next;
            odd = odd.next;
            even = even.next;
            cur = cur.next.next;
        }
        if (cur != null) {
            odd.next = cur;
        }
        evenH = reverse(evenH.next);
        odd.next = evenH;
        return oddH.next;
    }

    private ListNode reverse (ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode build (int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int a : array) {
            cur.next = new ListNode(a);
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void main (String[] args) {
        Y14ReverseAlternateNodes sol = new Y14ReverseAlternateNodes();
        ListNode head = sol.build(new int[]{1,2,3,4,5,6});
        sol.reverseAlternate(head);
    }
}
