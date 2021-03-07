import java.util.*;

public class Y9MTopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k)
    {
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
}
