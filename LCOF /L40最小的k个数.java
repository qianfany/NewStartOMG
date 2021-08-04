
import java.util.Comparator;
import java.util.PriorityQueue;

public class L40最小的k个数 {

    public int[] getLeastNumbers (int[] arr, int k) {
        int[] res = new int[k];
        if (arr == null || arr.length == 0 || k == 0 || k > arr.length) {
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

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                maxHeap.offer(arr[i]);
            } else if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        for (int j = 0; j < k; j++) {
            res[j] = maxHeap.poll();
        }
        return res;
    }
}
