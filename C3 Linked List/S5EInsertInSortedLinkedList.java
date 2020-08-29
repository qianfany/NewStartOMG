public class S5EInsertInSortedLinkedList {

    public ListNode insert (ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        // if the head is empty or the value is smaller than the head
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }
        ListNode prev = head;
        // when the next node is empty or the next value is bigger than value
        while (prev.next != null && prev.next.value < value) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
}
