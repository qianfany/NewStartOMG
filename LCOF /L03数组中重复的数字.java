import java.util.HashSet;
import java.util.Set;

public class L03数组中重复的数字 {
    /*
        [2,     3,      1,      0       2       5       3]
           2  or 3
     */
    public int findRepeatNumber (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return i;
            }
        }
        return 0;
    }
}
