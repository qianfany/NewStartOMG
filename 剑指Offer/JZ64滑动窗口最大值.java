import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class JZ64滑动窗口最大值 {
    /*
    use a deque
                    0   1   2   3   4   5   6   7   8
                    1   3   2   5   8   9   4   7   3
    key insight: when a[i] and a[j] are both in the slidinng window, i < j and
    a[i] <= a[j], we can remove a[i] from the sliding window without affecting the
    result, because a[i] can no longer be the max element in the sliding window

    Algorithm: Linear scan and look back
    when the sliding window moves to the right side by 1 step
        1 new element enters sliding window
            while deque.tail.value <= x:
                remove tail from deque
            dequeu.pushBack(x, index(x))
        the leftmost element (u) in the sliding window exists
            if (deque.head.index == index(y)):
                dequeu.popfront()
        update global max with dequeu.head.value (if latter is larger)

    Time: O(n)
     */
    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size < 1 || num.length == 0) return res;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - size) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= size - 1) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}
