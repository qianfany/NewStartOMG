import java.util.ArrayDeque;
import java.util.Deque;

public class L234PalindromeLinkedList extends BaseObject{
    /*
    2 pointer, to find middle point
    stack that stores the previous elements


    1 2 3 3 2 1
        s
            f
    1 2 3 2 1
        s
            f
     */
    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;
        stack.offerFirst(slow.val);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.offerFirst(slow.val);
        }
        if (fast.next == null) {
            stack.pollFirst();
        }
        while (slow.next != null) {
            if (stack.isEmpty() || stack.pollFirst() != slow.next.val) {
                return false;
            }
            slow = slow.next;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
