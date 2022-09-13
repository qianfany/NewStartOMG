import java.util.Arrays;

public class L147InsertionSortList extends BaseObject{


    /**
     *            -1      ->      5       ->      3       ->      4     ->      0
     *   pre      cur           mext
     *
     * @param head
     * @return
     */

    public ListNode insertionSortList (ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
    /*
    begin with 2nd item as by definition one item is considered to be sorted
    item at index i = key
    finding its correct index
    if key is smaller than the value of the item at index j
    then the key moves one position to the left
    the process continues until the case when we reach an element being smaller than the key
     */
    public void insertionSortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] input = {6, 2, 3, 4, 5, 1};
        L147InsertionSortList sol = new L147InsertionSortList();
        sol.insertionSortArray(input);
    }


}
