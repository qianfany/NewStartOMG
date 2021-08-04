
import java.util.Comparator;
import java.util.PriorityQueue;

public class L41数据流中的中位数 {

    private int counter = 0;
    private PriorityQueue<Integer> minheap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            return o1 < o2 ? 1 : -1;
        }
    });

    public void addNum (int num) {
        counter++;
        if ((counter & 1) == 1) {
            if (!minheap.isEmpty() && num > minheap.peek()) {
                minheap.offer(num);
                num = minheap.poll();
            }
            maxHeap.offer(num);
        } else {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minheap.offer(num);
        }
    }

    public double findMedian () {
        double res = 0;
        if ((counter & 1) == 1) {
            res = maxHeap.peek();
        } else {
            res = (maxHeap.peek() + minheap.peek()) / 2.0;
        }
        return res;
    }
}
