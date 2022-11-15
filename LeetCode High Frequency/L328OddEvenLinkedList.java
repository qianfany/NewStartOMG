public class L328OddEvenLinkedList extends BaseObject{
    /*
    solve in O(1) space
            keep track of even head node
            1   --  2   --  3   --  4   --  5
           odd     even
           odd -> even.next 1 -> 3
           odd -> odd.next  3
           even -> odd.next 2 -> 4
           even -> even .next 4

           combine odd-> even head

     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
