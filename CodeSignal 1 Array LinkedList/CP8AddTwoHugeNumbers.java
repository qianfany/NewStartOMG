public class CP8AddTwoHugeNumbers {

    public ListNode addTwoNum (ListNode a, ListNode b) {
        ListNode headA = reverse(a);
        ListNode headB = reverse(b);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (headA != null && headB != null) {
            int tmpSum = headA.value + headB.value + carry;
            int res = tmpSum % 10000;
            carry = tmpSum / 10000;
            cur.next = new ListNode(res);
            cur = cur.next;
            headA = headA.next;
            headB = headB.next;
        }

        while (headA != null) {
            int tmpSum = headA.value + carry;
            int res = tmpSum % 10000;
            carry = tmpSum / 10000;
            cur.next = new ListNode(res);
            cur = cur.next;
            headA = headA.next;
        }
        while (headB != null) {
            int tmpSum = headB.value + carry;
            int res = tmpSum % 10000;
            carry = tmpSum / 10000;
            cur.next = new ListNode(res);
            cur = cur.next;
            headB = headB.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(dummy.next);
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



}
