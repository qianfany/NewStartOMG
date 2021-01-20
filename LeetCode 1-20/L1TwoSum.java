import java.util.HashMap;
import java.util.Map;

public class L1TwoSum {
    /*
    Clarification:

    - return true or false or return index
    - data size
    - duplication (assume no duplication)
    - sorted vs unsorted
    - data type: int
    - optimize for time or optimize for space

    Return exactly 1 pair of solution
    Maintain  Map<Integer, Integer>
    key: number     value: index of the number
    for each step: iterate through every element
        put all elements into the map
    complement = target - nums[i]
    check if number is in the map
        if true
            return {i, map.get(complement)}
    Time: O(n) in average
    Space: O(n)
     */
    public int[] twoSum (int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
