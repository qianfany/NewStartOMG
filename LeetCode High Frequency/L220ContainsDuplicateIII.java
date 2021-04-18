import java.util.TreeSet;

public class L220ContainsDuplicateIII {
    /*
    |nums[i] - nums[j]| <= t && |i - j| <= k

     */
    public boolean containsNearbyAlmostDuplicate (int[] nums, int k, int t) {
        int length = nums.length;
        if (length == 0 || k <= 0 || t < 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (Math.abs(j - i) <= k
                        && Math.abs((long) nums[j] - (long) nums[i]) <= t ){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicateI(int[] nums, int k, int t) {
        int len = nums.length;
        // 特判
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            if (i > k) {
                set.remove((long) nums[i - k - 1]);
            }

            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }

            set.add((long) nums[i]);
        }
        return false;
    }

}
