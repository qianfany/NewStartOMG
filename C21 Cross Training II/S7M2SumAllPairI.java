import java.util.*;

public class S7M2SumAllPairI {
    /*
    return its index for all pairs that sum equals to target with duplication
    Maintain  Map<Integer, List<Integer>>
    key: number     value: list of all possible indices
    for each step: iterate through every element
    case 1: 2Sum exist, get all the index of (target - array[i])
            put (i, j) in result
    case 2.1: 2 sum not exist, array[i] not in map, put <array[i], new ArrayList>
    case 2.2: 2 sum not exist, array[i] already existed, map.get(array[i]).add(i)

     */
    public List<List<Integer>> allPairs (int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (int j : indices) {
                    result.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }
    /*
    return true or false or return index
    data size
    duplication (assume no duplication)
    sorted vs unsorted
    data type: int
    optimize for time or optimize for space

    Return exactly 1 pair of solution
    Maintain  Map<Integer, Integer>
    key: number     value: index of the number
    for each step: iterate through every element
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
