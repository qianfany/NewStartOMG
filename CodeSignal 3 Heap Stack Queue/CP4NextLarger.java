import java.util.ArrayDeque;
import java.util.Deque;

public class CP4NextLarger {

    public int[] nextLarger (int[] a) {
        int n = a.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] >= stack.peekFirst()) {
                stack.pollFirst();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.offerFirst(a[i]);
        }
        return result;
    }
}
