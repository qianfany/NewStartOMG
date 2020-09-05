import java.util.HashMap;
import java.util.Map;

public class JZ28MoreThanHalfNum {
    /*
    HashMap<int, int>
    key = array[i]
    value = frequency

    Time: O(n)
    Space: O(n)
     */
    public int moreThanHalf (int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : array) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > array.length /2) {
                res = num;
                break;
            }
        }
        return res;
    }
}
