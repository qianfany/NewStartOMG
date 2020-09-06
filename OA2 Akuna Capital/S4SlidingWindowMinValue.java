import java.util.*;

public class S4SlidingWindowMinValue {
    /*
    Sliding window
    use a deque
    when a[i] and a[j] are both in the sliding window,
     */
    public int segment (int x, List<Integer> space) {
        int max = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < space.size(); i++) {
            while (!deque.isEmpty() && space.get(deque.peekLast()) >= space.get(i)) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - x) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= x - 1) {
                max = Math.max(space.get(deque.peekFirst()), max);
            }
        }
        return max;
    }

    public static void main (String[] args) {
        S4SlidingWindowMinValue sol = new S4SlidingWindowMinValue();
        int x = 3;
        List<Integer> space = new ArrayList<>();
        space.add(2);
        space.add(5);
        space.add(4);
        space.add(6);
        space.add(8);
        System.out.println(sol.segment(x, space));
    }

}
