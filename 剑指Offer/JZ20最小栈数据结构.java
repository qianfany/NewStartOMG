import java.util.Deque;
import java.util.LinkedList;

public class JZ20最小栈数据结构 {

    private Deque<Integer> stack;
    private Deque<Integer> min;
    public JZ20最小栈数据结构 () {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }
        /*
    keep the adding & removing action in synchronization with each min()
    returns stack2.top()

    stack 1[   3  1 -7 -6 -8
    stack 2[   3  1 -7 -8
    stack1: is used to store input elements
    stack2: is used to store the min element so far in stack1

    Time: O(1)
    Space: O(n)
     */


    public void push (int node) {
        stack.push(node);
        if (min.isEmpty() || node <= min.peekFirst()) {
            min.offerFirst(node);
        }
    }

    public void pop () {
        if (stack.isEmpty()) {
            return;
        }
        int result = stack.pollFirst();
        if (min.peekFirst().equals(result)) {
            min.pollFirst();
        }
    }

    public int top () {
        return stack.peekFirst();
    }

    public int min () {
        return min.peekFirst();
    }
}
