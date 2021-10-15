import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L217ContainsDuplicate {
    /*
    Time: O(n log n)
    Space: O(n)
     */
    public boolean containsDuplicate (int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /*
    Time: O(n)
    Space: O(n)
     */
    public boolean containsDuplicateI (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
