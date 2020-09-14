public class L147InsertionSortList {


    /**
     *            4      ->      2       ->      1       ->      3
     *   dummy    cur           mext
     *
     * @param head
     * @return
     */

    public ListNode insertionSortList (ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode dummy = new ListNode(0);

        while (cur != null) {
            next = cur.next;
            ListNode pre = dummy;
            while (pre.next != null && pre.next.value < cur.value) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
