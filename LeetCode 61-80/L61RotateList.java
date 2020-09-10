public class L61RotateList {
    /*
    Algorithm:
    get the length
    move to the (l - n % l)th node
    do rotation

    1   ->  2   ->  3   ->  4   ->  5   ->  null    k = 2
                    s               f
    4   ->  5   ->  1   ->  2   ->  3   ->  null

    fast.next = head
    head = slow.next
    slow.next = null

    Time: O(n)
    Space: O(1)
     */
    public ListNode rotateRight (ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }

        for (int i = size - k % size; i > 1; i--) {
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
