import java.util.ArrayDeque;
import java.util.Deque;

public class L155MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> min;
    public L155MinStack () {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    /**
    keep the adding & removing action in synchronization with each min()
    returns stack2.top()

    stack 1[   3  1 -7 -6 -8
    stack 2[   3  1 -7 -8
    stack1: is used to store input elements
    stack2: is used to store the min element so far in stack1

    Time: O(1)
    Space: O(n)
     */

    public void push (int x) {
       stack.offerFirst(x);
       if (min.isEmpty() || x <= min.peekFirst()) {
           min.offerFirst(x);
       }
    }

    public void pop () {
        if (stack.isEmpty()) {
            return;
        }
        if (min.peekFirst().equals(stack.pollFirst())) {
            min.pollFirst();
        }
    }

    public int top () {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int getMin () {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peekFirst();
    }
}
