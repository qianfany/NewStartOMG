import java.util.HashSet;
import java.util.Set;

public class CP1FirstDuplicate {

    public int firstDuplicate (int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
