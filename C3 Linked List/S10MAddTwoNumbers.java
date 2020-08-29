public class S10MAddTwoNumbers {
    /*
    (2 -> 4 -> 3) + (5 -> 6 -> 4)

    termination condition: when l1 == null && l2 == null && carry == 0
    carry = carry % 10
    carry = carry / 10

     */

    public ListNode addTwoNumber (ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.value;;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.value;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry % 10);
            carry = carry /10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
