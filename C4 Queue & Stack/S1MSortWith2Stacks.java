import java.util.Deque;
import java.util.LinkedList;

public class S1MSortWith2Stacks {

    /*
    stack1: used for storing all unsorted element
    stack2: left part | right part
            left part: to store all sorted elements in previous iterations
            right part: used as a buffer to find the current smallest element
            maintain a counter for duplicate elements
            curMin to record the minimum element

     use
        while (stack2.size() > 0 && stack2.peek() >= global_min) {
              move stack2.top back to stack1
        }
     */
    public void sort (LinkedList<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<>();
        sort (s1, s2);
    }

    private void sort (Deque<Integer> input, Deque<Integer> buffer) {
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin) {
                    count++;
                }
                buffer.offerFirst(cur);
            }
            while (!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int tmp = buffer.pollFirst();
                if (tmp != curMin) {
                    input.offerFirst(tmp);
                }
            }
            while (count > 0) {
                buffer.offerFirst(curMin);
                count--;
            }
        }
        while (!buffer.isEmpty()) {
            input.offerFirst(buffer.pollFirst());
        }
    }
}
