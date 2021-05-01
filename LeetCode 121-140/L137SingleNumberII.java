import java.util.HashMap;
import java.util.Map;

public class L137SingleNumberII {
    /**
     * appears three times except one
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

    public int singleNumberBit (int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCount = oneCount + ((nums[j] >>> i) & 1);
            }
            if (oneCount % 3 == 1) {
                res = res | (1 << i);
            }
        }
        return res;
    }
}
