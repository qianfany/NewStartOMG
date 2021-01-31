import java.util.ArrayDeque;
import java.util.Deque;

public class L32LongestValidParentheses {
    /*
    Given a string containing just the characters '(' and ')',
    find the length of the longest valid (well-formed) parentheses substring.
    Use stack
    1. Scan the string from beginning to end
    2. add -1 to the stack for reference
    3. If current character is ')' and the
    character at the index of the top of stack is '(', we just find
    a matching pair so pop from the stack. and compute the length
    Only update result when we find a pair
    4. Otherwise: push its index to the stack

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
