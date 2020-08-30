import java.util.*;

public class S4MAllValidPermutationOfParenthesesIII {
    /*
        {} > [] > ()
        case 1: whenever we add a new left parentheses, we first check the priority of the current parentheses
        against the top of the stack, and then push to the stack, add it to the solution prefix
        case 2: same as S3

     */
    private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};

    public List<String> validParenthesesIII (int l, int m, int n) {
        int[] remain = new int[] {l, l, m, m, n, n};
        int targetLen = 2 * l + 2 * m + 2 * n;
        StringBuilder cur = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        helper (cur, stack, remain, targetLen, result);
        return result;
    }

    private void helper (StringBuilder cur, Deque<Integer> stack, int[] remain, int targetLen,
                         List<String> result) {
        if (cur.length() == targetLen) {
            result.add(cur.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                    cur.append(PS[i]);
                    stack.offerFirst(i);
                    remain[i]--;
                    helper(cur, stack, remain, targetLen, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            }
            else {
                if (!stack.isEmpty() && stack.peekFirst() == i - 1) {
                    cur.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(cur, stack, remain, targetLen, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.offerFirst(i - 1);
                    remain[i]++;
                }
            }
        }
    }
}
