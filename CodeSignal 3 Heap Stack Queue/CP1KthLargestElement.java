import java.util.Comparator;
import java.util.PriorityQueue;

public class CP1KthLargestElement {

    public int kthLargestElement (int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.offer(nums[i]);
            } else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.poll();
    }
}
