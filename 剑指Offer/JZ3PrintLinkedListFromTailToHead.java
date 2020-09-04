import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class JZ3PrintLinkedListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode (int val) {
            this.val = val;
        }
    }
    /*
    use stack: add all the number into the stack
    FILO
    Time:   O(n)
    Space:  O(n)
     */
    public ArrayList<Integer> printListFromTailToHead (ListNode listNode) {
        ListNode head = listNode;
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.offerFirst(head.val);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pollFirst());
        }
        return list;
    }
}
