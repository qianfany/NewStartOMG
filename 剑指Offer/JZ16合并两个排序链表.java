public class JZ16合并两个排序链表 {
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
    public ListNode merge (ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }
        return dummy.next;
    }
}
