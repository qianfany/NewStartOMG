public class S9MMergeSortLinkedList {
    /*
                        52741386
                  /                 \
                5274               1386                     Time = O(n)
               /    \              /   \
              52     74           13    86                  Time = O(n)
             /  \    / \          / \   / \
            5   2    7  4        1   3  8   6               Time = O(n)
            5   2    7  4        1   3  8   6          total Time: O(n)
            \   /    \  /         \  /   \ /
              25      47           13     68                Time = O(n)
                \     /              \   /
                  2457                1368                  Time = O(n)
                      \               /
                          12345678                          Time = O(n)
                                                       total Time: O(n log n)
                                                       total space: O(log n)
     */
    public ListNode mergeSort (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle (head);
        ListNode head2 = mid.next;
        mid.next = null;
        return merge(mergeSort(head), mergeSort(head2));
    }

    private ListNode findMiddle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge (ListNode one, ListNode two) {
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
