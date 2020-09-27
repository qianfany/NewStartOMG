import java.util.Arrays;
import java.util.PriorityQueue;

public class Y7SortNearlySortedArray {
    /**
     * using heap, initially put k + 1 elements into the min heap
     * then put elements into the array  using minheap.poll
     * add another element into the heap
     * post processing, add all the elements in heap to the array
     * @param array
     * @param k
     * @return
     */
    public int[] kSort (int[] array, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(array[i]);
        }
        int index = 0;
        for (int i = k + 1; i < array.length; i++) {
            array[index++] = priorityQueue.poll();
            priorityQueue.offer(array[i]);
        }

        for (int i = index; i < array.length; i++) {
            array[i] = priorityQueue.poll();
        }
        return array;
    }

    public static void main (String[] args) {
        Y7SortNearlySortedArray sol = new Y7SortNearlySortedArray();
        int[] array = new int[] {2,1,4,3,5};
        System.out.print(Arrays.toString(sol.kSort(array, 1)));
    }
}
