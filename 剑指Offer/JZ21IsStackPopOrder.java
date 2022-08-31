import java.util.ArrayDeque;
import java.util.Deque;

public class JZ21IsStackPopOrder {
    /*
    LeetCode 946:  Validate Stack Sequences
    1   2   3   4   5
    4   5   3   2   1
    stack
    [ 1                         i = 0, index = 0
    [ 1, 2                      i = 1, index = 0
    [ 1, 2, 3                   i = 2, index = 0
    [ 1, 2, 3, 4                i = 3, index = 0   stack.top = popped[0]     stack.poll, index++
    [ 1, 2, 3                   stack.top != popped[1]
    [ 1, 2, 3, 5                stack.top == popped[1] stack.poll, index++
    [ 1, 2, 3                   stack.top == popped[2] stack.poll, index++
    [ 1, 2                      stack.top == popped[3] stack.poll, index++
    [ 1                         stack.top == popped[4] stack.poll, index++
    [                           stack.isEmpty = true

    1   2   3   4   5
    4   3   5   1   2

    [ 1                         i = 0, index = 0
    [ 1, 2                      i = 1, index = 0
    [ 1, 2, 3                   i = 2, index = 0
    [ 1, 2, 3, 4                i = 3, index = 0   stack.top = popped[0]     stack.poll, index++
    [ 1, 2, 3                   stack.top != popped[1]  i++
    [ 1, 2, 3, 5                stack.top != popped[1]  at the end of the array
    break the while loop
    [ 1, 2, 3, 5                stack.isEmpty = false

    maintain a stack, add the element into the stack
    linear scan and add elements in pushA into the stack until match

    case 1: stack.peek() == popA[i]
        stack.pop; i++
    case 2:
        continue
    termination condition: pushA is empty, check the stack is empty
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

    public boolean validateStackSequences(int[] pushed, int[] popped) {
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
