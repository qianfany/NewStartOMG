import java.util.*;

public class L347TopKFrequentElements {
    /*
    1   3
    2   2
    3   1

     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums)
        {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minFreqHeap = new PriorityQueue<>(Comparator.comparingInt(numCountMap::get));
        for (int num : numCountMap.keySet())
        {
            minFreqHeap.add(num);
            if (minFreqHeap.size() == k + 1)
            {
                minFreqHeap.poll();
            }
        }
        return minFreqHeap.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        L347TopKFrequentElements sol = new L347TopKFrequentElements();
        System.out.println(sol.topKFrequent(nums, k));
    }
}
