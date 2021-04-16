import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class L09用两个栈实现队列 {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public L09用两个栈实现队列 () {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    private void shuffle () {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.offerFirst(stack1.pollFirst());
            }
        }
    }

    public void appendTail (int value) {
        stack1.offerFirst(value);

    }

    public int deleteHead () {
        shuffle();
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pollFirst();
    }
}
