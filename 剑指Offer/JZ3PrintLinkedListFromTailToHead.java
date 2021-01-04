import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class JZ3PrintLinkedListFromTailToHead {
    /*
    use stack: add all the number into the stack
    67  ->  0  ->  24  -> 58
    {58, 24, 0, 67}
    FILO
    Time:   O(n)
    Space:  O(n)
     */
    public ArrayList<Integer> printListFromTailToHead (ListNode listNode) {
        ListNode head = listNode;
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.offerFirst(head.value);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pollFirst());
        }
        return list;
    }
}
