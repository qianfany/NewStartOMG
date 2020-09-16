public class CP10ReverseKGroup {

    public ListNode reverseKGroup (ListNode l, int k) {
        //1. test weather we have more then k node left, if less then k node left we just return head
        ListNode node = l;
        int count = 0;
        while (count < k) {
            if(node == null) {
                return l;
            }
            node = node.next;
            count++;
        }
        // 2.reverse k node at current level
        ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem
        while (count > 0) {
            ListNode next = l.next;
            l.next = pre;
            pre = l;
            l = next;
            count = count - 1;
        }
        return pre;
    }
}
