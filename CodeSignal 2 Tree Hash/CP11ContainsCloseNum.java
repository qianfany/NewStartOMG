import java.util.HashMap;
import java.util.Map;

public class CP11ContainsCloseNum {
    /**
     * Map <Integer, Integer>
     *     key = number
     *     value = indices
     *  Greedy approach
     *     check duplication and find the the differences
     * @param nums
     * @param k
     * @return
     */
    public boolean containsCloseNums (int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int difference = i - map.get(nums[i]);
                if (difference <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main (String[] args) {
        CP11ContainsCloseNum sol = new CP11ContainsCloseNum();
        int[] nums = {0, 1, 2, 3, 5, 2};
        System.out.println(sol.containsCloseNums(nums, 3));
    }
}
