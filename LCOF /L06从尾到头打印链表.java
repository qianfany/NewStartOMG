import java.util.ArrayDeque;
import java.util.Deque;

public class L06从尾到头打印链表 {

    public int[] reversePrint (ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.offerFirst(cur.value);
            cur = cur.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }
}
