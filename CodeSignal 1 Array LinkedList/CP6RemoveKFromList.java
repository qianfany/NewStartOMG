public class CP6RemoveKFromList {

    public ListNode removeKFromList (ListNode l, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = l;
        ListNode current = l;
        ListNode previous = dummy;
        while (current != null) {
            if (current.value == k) {
                previous.next = current.next;
            }
            else {
                previous = current;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
