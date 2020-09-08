import java.util.ArrayDeque;
import java.util.Deque;

public class L20ValidParentheses {
    /*
    maintain a stack
    if its left parentheses,    stack.offer
    if its right parentheses,   check if c == stack.poll

    termination condition:  iterate through the whole string
    and check if the stack is empty

    Time: O(n)
    Space: O(n)
     */
    public boolean isValid (String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '(' || c == '[' || c == '{') {
                stack.offerFirst(c);
            }
            else if (stack.isEmpty()) {
                return false;
            }
            else if (c == ')' && stack.pollFirst() != '(') {
                return false;
            }
            else if (c == ']' && stack.pollFirst() != '[') {
                return false;
            }
            else if (c == '}' && stack.pollFirst() != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
