public class S3EMiddleNodeOfLinkedList {
    /*
    two pointer:
    fast    ->  jump twice  when fast reach null or next is null return slow
    slow    ->  jump once
     */
    public ListNode middleNode (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
