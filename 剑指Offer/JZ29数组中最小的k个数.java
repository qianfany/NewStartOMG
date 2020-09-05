import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JZ29数组中最小的k个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k == 0 || k > input.length) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? 1 : -1;
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (int j = 0; j < k; j++) {
            res.add(maxHeap.poll());
        }
        Collections.reverse(res);
        return res;

    }
}