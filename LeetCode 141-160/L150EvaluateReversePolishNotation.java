import java.util.ArrayDeque;
import java.util.Deque;

public class L150EvaluateReversePolishNotation {
    /*
      Use stack
      maintain a stack, linear scan through the array
      put the number into the stack
      whenever we met operators, poll two operators out
      do the operation and push it result into the stack
      termination condition, reach the end of the array
      Time: O(n)
      Space: O(n)
     */
    public int evalRPN (String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
                int right = deque.pollFirst();
                int left = deque.pollFirst();
                if (s.equals("*")) {
                    deque.offerFirst(left * right);
                }
                else if (s.equals("/")) {
                    deque.offerFirst(left / right);
                }
                else if (s.equals("+")) {
                    deque.offerFirst(left + right);
                }
                else if (s.equals("-")) {
                    deque.offerFirst(left - right);
                }
            } else {
                deque.offerFirst(Integer.valueOf(s));
            }
        }
        return deque.peekFirst();
    }
}
