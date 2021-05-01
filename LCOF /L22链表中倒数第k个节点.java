public class L22链表中倒数第k个节点 {

    public ListNode getKthFromEnd (ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            head = head.next;
            cur = cur.next;
        }
        return head;
    }
}
