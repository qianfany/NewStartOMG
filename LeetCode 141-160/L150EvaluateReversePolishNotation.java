import java.util.ArrayDeque;
import java.util.Deque;

public class L150EvaluateReversePolishNotation {
    /**
     * Use stack
     * Time: O(n)
     * Space: O(n)
     * @param tokens
     * @return
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
