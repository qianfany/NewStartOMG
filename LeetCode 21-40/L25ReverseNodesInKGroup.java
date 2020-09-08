public class L25ReverseNodesInKGroup {
    /*
    Time: O(n)
    Space: O(n/k)
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        //1. test weather we have more then k node left, if less then k node left we just return head
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if(node == null) {
                return head;
            }
            node = node.next;
            count++;
        }
        // 2.reverse k node at current level
        ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count = count - 1;
        }
        return pre;
    }
}
