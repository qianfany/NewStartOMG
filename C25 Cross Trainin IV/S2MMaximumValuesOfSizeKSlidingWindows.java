import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S2MMaximumValuesOfSizeKSlidingWindows {
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
    public List<Integer> maxWindows (int[] array, int k) {
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
}
