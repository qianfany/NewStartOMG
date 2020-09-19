import java.util.ArrayDeque;
import java.util.Deque;

public class Y13MAddTwoNumbersII {
    /**
     * Input: 	 (7 →  2  →  4  →   3) + (5  →   6   →   4)
     * output:  (7 →  8  →  0  →   7)
     * Using two stacks
     * when append to the linkedList,
     * maintain a dummy node, always insert at the front of linkedList
     * Time: O(n)				Space: 	O(n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.offerFirst(l1.value);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offerFirst(l2.value);
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
