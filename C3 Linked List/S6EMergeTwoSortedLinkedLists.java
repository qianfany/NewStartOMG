public class S6EMergeTwoSortedLinkedLists {
    /*
    merge
    maintain a dummy node
    set pointer on each node
    iterate through both node
    termination condition:
    one of the node is null, add the rest of the other node
    Time: O(n) n is the number of elements in the linkedList
    Space: O(n)
     */
    public ListNode merge (ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }
}
