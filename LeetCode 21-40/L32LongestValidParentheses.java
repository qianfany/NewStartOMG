import java.util.ArrayDeque;
import java.util.Deque;

public class L32LongestValidParentheses {
    /*
    Use stack

    Only update result when we find a pair
    )()())
    stack [ -1, 0, 1

    result = (0, 2 - 0) = 2

    Time: O(n)
    Space: O(n)
     */
    public int longestValidParentheses (String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        stack.offerFirst(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peekFirst()) == '(') {
                stack.pollFirst();
                result = Math.max(result, i - stack.peekFirst());
            }
            else {
                stack.offerFirst(i);
            }
        }
        return result;
    }
}
