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

    public ListNode build (int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int a : array) {
            cur.next = new ListNode(a);
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroupIterative (ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, next = dummy, pre = dummy;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        while (count >= k) {
            cur = pre.next;
            next = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }

    public static void main (String[] args) {
        L25ReverseNodesInKGroup sol = new L25ReverseNodesInKGroup();
        int[] array = {1, 2, 3, 4, 5};
        ListNode list = sol.build(array);
        sol.reverseKGroup(list, 2);
    }
}
