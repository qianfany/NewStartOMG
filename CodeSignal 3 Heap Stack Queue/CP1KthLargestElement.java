import java.util.Comparator;
import java.util.PriorityQueue;

public class CP1KthLargestElement {
    /*
    1.  sorting
        time: O(N log N)        space:  O(1)
    2.  PriorityQueue           min-Heap
        time: O(N log k)        space:  O(k)
    3.  QuickSelect
        Time: O(N)              Space:  O(1)

     */
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

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }
}
