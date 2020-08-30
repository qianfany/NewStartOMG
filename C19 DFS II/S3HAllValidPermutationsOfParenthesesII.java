
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S3HAllValidPermutationsOfParenthesesII {
    /*
    Additional restrictions for getting a valid permutations
        = for the same type of brackets, left_added_so_far > right_added_so_far
        = for the same type of brackets, its left bracket must match the kind of right brackets,
         no matter how many other brackets are in between

   Depth first Search
   How many levels in the recursion tree, what does it store on each level
    2l + 2m + 2n
   How many different states should we try to put on each level
    3 * 2 states
    use only one stack, defined in the main function and passed into the recursion function as an argument
                                root = empty
                     /      |       |       |       |       \
                   (        )       [       ]       {       }
                 stack|| (
            /||||||\
           ( )[ ] { }
    case 1: whenever we add a new left parenthesis, check left_added_so_far, push to the stack, add
    it to the solution prefix
    case 2: whenever we add a new right parenthesis, we first check if it matches the top of the stack
            case 2.1: if matches: stack.pop(), add it to the solution prefix
            case 2.2: if not matches: skip this branch (do not call the recursion function)

     */
    private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};
    public List<String> validParentheses (int l, int m, int n) {
        int[] remain = new int[] {l, l, m, m, n, n};
        int targetLen = 2 * l + 2 * m + 2 * n;
        StringBuilder cur = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        List<String> result = new ArrayList<>();
        helper (cur, stack, remain, targetLen, result);
        return result;
    }

    private void helper (StringBuilder cur, Deque<Character> stack, int[] remain, int targetLen,
                         List<String> result) {
        if (cur.length() == targetLen) {
            result.add(cur.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {   // left parentheses
                if (remain[i] > 0) {
                    cur.append(PS[i]);
                    stack.offerFirst(PS[i]);
                    remain[i]--;
                    helper(cur, stack, remain, targetLen, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            }
            else {
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
                    cur.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(cur, stack, remain, targetLen, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.offerFirst(PS[i - 1]);
                    remain[i]++;
                }
            }
        }
    }
}
