import java.util.Comparator;
import java.util.PriorityQueue;

public class JZ63MedianInAStreamOfData {
    /*
    Maintain two heaps, minHeap and a maxHeap
    minHeap stores the larger value
    MaxHeap stores the small value

    for Heap operations:
      counter is odd
        if (num > minheap.peek)
            minheap.offer(num)
            num = minHeap.poll
        maxheap.offer(num)
      counter is even
        if (num < maxHeap.peek)
            maxHeap.offer(num)
            num = maxHeap.poll
        minHeap.offer(num)

    if counter is odd, maxHeap.peek
    otherwise          (maxheap.peek + minHeap.peek) / 2.0
    Time: insert O(log n) getMedian O(1)
    Space: O(1)
     */
    private int counter = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            return o1 < o2 ? 1 : -1;
        }
    });

    public void Insert(Integer num) {
        counter++;
        if ((counter & 1) == 1) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
        else {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    public Double GetMedian() {
        double res = 0;
        if ((counter & 1) == 1) {
            res = maxHeap.peek();
        } else {
            res = (maxHeap.peek() + minHeap.peek()) /2.0;
        }
        return res;
    }
}
