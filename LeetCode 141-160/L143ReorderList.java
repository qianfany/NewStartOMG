public class L143ReorderList {
    /*
    N1 -> N2 -> N3 -> N4 -> Nn
    N1 -> Nn -> N2 -> Nn-1 -> N3 ...

    1. find the middle node break from middle
    2. reverse the second half
    3. merge them together
     */
    public void reorderList (ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle (head);
        ListNode two = mid.next;
        mid.next = null;
        two = reverse(two);
        merge (head, two);
    }
    private ListNode reverse (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode findMiddle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge (ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }
}
