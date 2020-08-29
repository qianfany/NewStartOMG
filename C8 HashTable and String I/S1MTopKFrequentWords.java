import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class S1MTopKFrequentWords {
    /*
    put every element into the hashMap <String, int>
    value is teh frequency
    Maintain a MIN heap of size k, --> compare by frequency --> top k frequent candidates
    iterate over the hash_table <String, int>
    for each <String_i, int_i>,
        if int_t Min_heap.top().value(), call Min_heap.pop() and min_heap.insert(<>)
        else do nothing
        Time: O(n log k)
     */
    public String[] topKFrequent (String[] combo, int k) {
        if (combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> freqMap = getFreqMap(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return freqArray(minHeap);
    }


    private Map<String, Integer> getFreqMap (String[] combo) {
        Map<String, Integer> freeMap = new HashMap<>();
        for (String s: combo) {
            Integer freq = freeMap.get(s);
            if (freq == null) {
                freeMap.put(s, 1);
            } else {
                freeMap.put(s, freq + 1);
            }
        }
        return freeMap;
    }

    private String[] freqArray (PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }


}
