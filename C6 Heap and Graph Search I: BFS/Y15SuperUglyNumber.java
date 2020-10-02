import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Y15SuperUglyNumber {

    public int nthSuperUglyNumber (int n, int[] primes) {
        int k = primes.length;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        minHeap.offer(1L);
        visited.add(1L);
        while (n > 1) {
            long current = minHeap.poll();
            for (int num : primes) {
                if (visited.add(num * current)) {
                    minHeap.offer(num * current);
                }
            }
            n--;
        }
        return minHeap.peek().intValue();
    }
}
