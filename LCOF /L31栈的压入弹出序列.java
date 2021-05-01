import java.util.ArrayDeque;
import java.util.Deque;

public class L31栈的压入弹出序列 {
    /*
    1       2       3       4       5
    4       5       3       2       1
    stack [ 1   2   3   4

    maintain a stack, add the element into the stack
    linear scan and add elements in pushed into the stack until match

    case 1: stack.peek() == popped[i]
        stack.pop;
        i++
    until: pushed is empty, check the stack is empty
    Time:   O(n)
    Space:  O(n)
     */
    public boolean validateStackSequences (int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed.length == 0 || popped.length == 0) {
            return false;
        }
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.offerFirst(pushed[i]);
            while (!stack.isEmpty() && stack.peekFirst() == popped[index]) {
                stack.pollFirst();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
