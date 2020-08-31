import java.util.*;

public class S8M2SumAllPairII {
    /*
    return all distinct pairs
    Maintain a hashMap <Integer, Integer>
    key = num value     value = # of num
    case 1: check if num * 2 == target and count > 1
        result.add
    case 2: check 2Sum exist and count == null
        result.add
    add num and its count into the map
     */
    public List<List<Integer>> allPairs (int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                result.add(Arrays.asList(num, num));
            } else if (map.containsKey(target - num) && count == null) {
                result.add(Arrays.asList(target - num, num));
            }
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return result;
    }
}
