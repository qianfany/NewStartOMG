import java.util.ArrayDeque;
import java.util.Deque;

public class JZ21IsStackPopOrder {
    /*
    1   2   3   4   5
    4   5   3   2   1
    stack [ 1 2 3 4

    maintain a stack, add the element into the stack
    linear scan and add all element in pushA into the stack
    meanwhile
    check stack.peek() == popA[i]
    case 1: stack.peek() == popA[i]
        stack.pop; i++
    case 2:
        continue
    termination condition: check the stack if its empty
    Time: O(n)
    Space: O(n)
     */
    public boolean isPopOrder (int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < pushA.length; i++) {
            stack.offerFirst(pushA[i]);
            while (!stack.isEmpty() && stack.peekFirst() == popA[index]) {
                stack.pollFirst();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
