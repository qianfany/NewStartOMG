import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class L264UglyNumberII {

    public int nthUglyNumber (int n) {
        if (n <= 0) return 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>(n);
        Set<Long> visited = new HashSet<>();
        minHeap.offer(1L);
        visited.add(1L);
        while (n > 1) {
            long current = minHeap.poll();
            if (visited.add(2 * current)) {
                minHeap.offer(2 * current);
            }
            if (visited.add(3 * current)) {
                minHeap.offer(3 * current);
            }
            if (visited.add(5 * current)) {
                minHeap.offer(5 * current);
            }
            n--;
        }
        long res = minHeap.peek();
        int ugly = (int) res;
        return ugly;
    }
}
