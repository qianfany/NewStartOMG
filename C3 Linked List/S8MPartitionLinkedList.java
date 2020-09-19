public class S8MPartitionLinkedList {
    /*
    input: 1 →  6  →  3  →   2a  →   5  →   2b  			and target = 4
    result: 1  →   3  →  2a  →   2b  →   6   →   5
     allocate two new linkedList heads (one for small values and one for large values)
    iterate over every single element in the list, and compare with the current node’s
    current.value < target.value  	add to tail of the small
    add to the other linked list
    Concatenate the tail of the first half to the head of the 2nd linked list
    set the large list.next = null
     */
    public ListNode partition (ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null) {
            if (head.value < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            }
            else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        curLarge.next = null;
        return small.next;
    }
}
