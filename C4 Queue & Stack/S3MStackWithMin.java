import java.util.Deque;
import java.util.LinkedList;

public class S3MStackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> min;
    public S3MStackWithMin () {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }
    /*
    keep the adding & removing action in synchronization with each min()
    returns stack2.top()

    stack 1[   3  1 -7 -6 -8
    stack 2[   3  1 -7 -7 -8
    stack1: is used to store input elements
    stack2: is used to store the min element so far in stack1

    Time: O(1)
    Space: O(n)
     */
    public Integer pop () {
        if (stack.isEmpty()) {
            return -1;
        }
        Integer result = stack.pop();
        if (min.peekFirst().equals(result)) {
            min.pollFirst();
        }
        return result;
    }

    public void push (int element) {
        stack.offerFirst(element);
        if (min.isEmpty() || element <= min.peekFirst()) {
            min.offerFirst(element);
        }
    }

    public Integer top () {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public Integer min () {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peekFirst();
    }
}
