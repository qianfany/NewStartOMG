public class L86PartitionList {
    /**
    initialize two dummy node
    linear scan to whole linked list
    case 1: head < x
        curSmall.next = head   curSmall = curSmall.next
    case 2: head >= x
        curLarge.next = head  curLarge = curLarge.next

    post processing,
    curSmall.next = large.next
    cuLarge.next = null
    return small.next

    Time:   O(n)
    Space:  O(n)
     **/
    public ListNode partition (ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;

        while (head != null) {
            if (head.value < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
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
