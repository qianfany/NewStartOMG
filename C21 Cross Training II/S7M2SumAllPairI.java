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
}
