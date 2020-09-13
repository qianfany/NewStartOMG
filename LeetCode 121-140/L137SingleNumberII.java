import java.util.HashMap;
import java.util.Map;

public class L137SingleNumberII {
    /**
     * O(N) time
     * O(N) space
     * @param nums
     * @return
     */
    public int singleNumber (int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums)
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

        for (int k : hashmap.keySet())
            if (hashmap.get(k) == 1) return k;
        return -1;
    }
}
