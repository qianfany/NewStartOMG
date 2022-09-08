import java.util.ArrayDeque;
import java.util.Deque;

public class L445AddTwoNumbersII extends BaseObject{
        /*
        [7, 2, 4, 3]        [3]
        [5, 6, 4]           [4]

     d   [8, 0, 7]
         */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> stack1 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.offerFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offerFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            if (!stack1.isEmpty()) {
                carry += stack1.pollFirst();
            }
            if (!stack2.isEmpty()) {
                carry += stack2.pollFirst();
            }
            ListNode node = new ListNode(carry % 10);
            if (dummy.next != null) {
                node.next = dummy.next;
            }
            dummy.next = node;
            carry /= 10;
        }
        return dummy.next;
    }
}
