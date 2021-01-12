import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class JZ33KthSmallestWithOnly235Factor {
    /*
    Best first search
    use a min heap, put all the value <2, 3, 5> into the heap
    we use the actual product value to represent the states <x,y,z>
    the value is 2^x * 3^y * 5^z and the initial state is <0, 0, 0>

    Time: O(k log k)
     */
    public int getUglyNumber (int index) {
        if (index <= 0) return 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>(index);
        Set<Long> visited = new HashSet<>();
        minHeap.offer(1L);
        visited.add(1L);
        while (index > 1) {
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
            index--;
        }
        return minHeap.peek().intValue();
    }

    public int getUglyNumberI (int index) {
        if (index <= 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(index);
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(1);
        visited.add(1);
        while (index > 1) {
            int current = minHeap.poll();
            if (visited.add(2 * current)) {
                minHeap.offer(2 * current);
            }
            if (visited.add(3 * current)) {
                minHeap.offer(3 * current);
            }
            if (visited.add(5 * current)) {
                minHeap.offer(5 * current);
            }
            index--;
        }
        return minHeap.peek();
    }
}
