public class L21MergeTwoSortedLists {
    /*
    merge
    maintain a dummy node
    set a pointer on each node
    iterate through both node and compare
    small node will be connected with the previous
    termination condition:
    one of the node is null, add the rest of the other node
    Time: O(n) n is the number of elements in the linkedList
    Space: O(n)
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
