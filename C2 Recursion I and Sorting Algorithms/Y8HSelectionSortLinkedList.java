public class Y8HSelectionSortLinkedList {

    public ListNode selectionSort (ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            swap(cur, findMin(cur));
        }
        return head;
    }

    private void swap (ListNode x, ListNode y) {
        if (x != y) {
            int tmp = x.value;
            x.value = y.value;
            y.value = tmp;
        }
    }

    private ListNode findMin (ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode min = head;
        for (ListNode cur = head.next; cur != null; cur = cur.next) {
            if (min.value > cur.value) {
                min = cur;
            }
        }
        return min;
    }
}
