import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CP5MinimumOnStack {

    public int[] minimumOnStack (String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stackMin = new ArrayDeque<>();
        List<Integer> res= new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            if (s.startsWith("push")) {
                Integer val = Integer.valueOf(s.split(" ")[1]);
                stack.offerFirst(val);
                if (stackMin.isEmpty()) {
                    stackMin.offerFirst(val);
                } else {
                    stackMin.offerFirst(Math.min(stackMin.peekFirst(), val));
                }
            } else if (s.equals("pop") && !s.isEmpty()) {
                stackMin.pollFirst();
                stack.pollFirst();
            } else if (s.equals("min")) {
                res.add(stackMin.peekFirst());
            }
        }
        return res.stream().mapToInt(n -> n).toArray();
    }
}
