public class L83RemoveDuplicatesFromSortedList {
    /*

    1 -> 1 -> 2 -> 3 -> 3
    1 -> 2 -> 3
    Time: O(n)
    Space: O(1)
     */
    public ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode list = head;
        while (list.next != null) {
            if (list.value == list.next.value){
                list.next = list.next.next;
            }
            else {
                list = list.next;
            }
        }
        return head;
    }
}
