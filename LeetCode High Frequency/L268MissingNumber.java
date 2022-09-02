import java.util.HashSet;
import java.util.Set;

public class L268MissingNumber {

    public int missingNumber (int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int number : nums) {
            set.add(number);
        }
        for (int i = 0; i < size; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return size;
    }
}
