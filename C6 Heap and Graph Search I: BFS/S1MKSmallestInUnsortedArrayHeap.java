import java.util.Comparator;
import java.util.PriorityQueue;

public class S1MKSmallestInUnsortedArrayHeap {
    /*
    Solution 1: (min-heap)
    step 1: heapify all elements -> O(n)
    step 2: call pop() k times to get the k smallest element O(k log n)
    Time: O(n + k log n)

    Solution 2: (max Heap of size k -> smallest k candidates)  online algorithm
    step 1: heapfiy the first k elements to form a max-heap of size = k  O(k)
    step 2: Iterate over the remaining (n - k) elements one by one
            when we traverse a new element:
                compare with the largest element of the previous smallest k candidates
                    case 1: new element >= top : ignore
                    otherwise: update(top -> new element)
            O((n - k) log k)
    Time: O(k + (n - k) log k)

     */
    public int[] kSmallest (int[] array, int k) {
        if (array == null || k == 0 || array.length == 0) {
            return new int[0];
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

        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int [] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
