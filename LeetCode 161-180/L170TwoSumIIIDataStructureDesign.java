import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L170TwoSumIIIDataStructureDesign {
    /**
     * two cases:
     *  1. more find and less add
     *  2. less find and more add
     */
    Set<Integer> sum;
    Set<Integer> num;
    public L170TwoSumIIIDataStructureDesign () {
        sum = new HashSet<>();
        num = new HashSet<>();
    }

    public void add (int number) {
        for (int n : num) {
            sum.add(number + n);
        }
        num.add(number);
    }

    public boolean find (int value) {
        return sum.contains(value);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public void addI (int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean findI (int value) {
        for (int key : map.keySet()) {
            int remain = value - key;
            if (remain == key && map.get(key) >= 2) {
                return true;
            }
            if (remain != key && map.containsKey(remain) ) {
                return true;
            }
        }
        return false;
    }

}
