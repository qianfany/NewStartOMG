import java.util.ArrayDeque;
import java.util.Deque;

public class L30包含MIN函数的栈 {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    public L30包含MIN函数的栈 () {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    /*
    keep the adding & removing action in synchronization with each min()

    stack is used to store input element
    min is used to store the min element so far in stack

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

    public int min () {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peekFirst();
    }
}
