import java.util.Comparator;
import java.util.PriorityQueue;

public class L703KLargestElementInStream {

    private PriorityQueue<Integer> minHeap;
    private int k;
    public L703KLargestElementInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        L703KLargestElementInStream test = new L703KLargestElementInStream(k, nums);
        System.out.println(test.add(3));
        System.out.println(test.add(5));
        System.out.println(test.add(10));
        System.out.println(test.add(9));
        System.out.println(test.add(4));
    }
}
