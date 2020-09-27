import java.util.Collections;
import java.util.PriorityQueue;

public class Y6MedianTracker {

    private PriorityQueue<Integer> smallerHalf;
    private PriorityQueue<Integer> largerHalf;

    public Y6MedianTracker () {
        largerHalf = new PriorityQueue<>();
        smallerHalf = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    public void read (int value) {
        if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
            smallerHalf.offer(value);
        } else {
            largerHalf.offer(value);
        }
        if (smallerHalf.size() - largerHalf.size() >= 2) {
            largerHalf.offer(smallerHalf.poll());
        } else if (largerHalf.size() > smallerHalf.size()) {
            smallerHalf.offer(largerHalf.poll());
        }
    }

    public Double median() {
        int size = size();
        if (size == 0) {
            return null;
        } else if ((size & 1) == 1) {
            return (double) (smallerHalf.peek());
        } else {
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        }
    }

    private int size () {
        return smallerHalf.size() + largerHalf.size();
    }
}
