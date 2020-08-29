import java.util.ArrayDeque;
import java.util.Deque;

public class S7HRemoveAdjacentRepeatedCharactersIV {
    /*
    a b b b b a z w --->  a a z w ---> z w
    stack:
    j = 0: (fast) the letter being processed . In other words, all letters to the left side of j
    not including j  are processed letters
    stack: all the processed letters that should be kept

    for each step
    case 1: a[f] != stack.top(), then stack.push(a[f]), ++f
    case 2: a[f] == stack.top(),
            keep moving f until a[f] != stack.top()
            stack.pop()
     */
    public String deDup (String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int fast = 0;
        while (fast < array.length) {
            char curChar = array[fast];
            if (!stack.isEmpty() && stack.peekFirst() == curChar) {
                while (fast < array.length && array[fast] == curChar) {
                    fast++;
                }
                stack.pollFirst();
            } else {
                stack.offerFirst(curChar);
                fast++;
            }
        }
        int len = stack.size();
        for (int i = len - 1; i >= 0; i--) {
            array[i] = stack.pollFirst();
        }
        return new String(array, 0, len);
    }
}
