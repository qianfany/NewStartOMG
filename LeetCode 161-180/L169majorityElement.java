import java.util.HashMap;
import java.util.Map;

public class L169majorityElement {
    /**
     * Boyer-Moore Voting Algorithm
     *      2   2   1   1   1   2   2
     *      count =
     *      candidate =
     * @param nums
     * @return
     * time: O(N)
     * Space: O(1)
     */
    public int majorityElement (int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElementI(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > half) {
                res = num;
                break;
            }
        }
        return res;
    }
}
