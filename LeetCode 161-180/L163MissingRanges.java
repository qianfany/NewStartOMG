import java.util.ArrayList;
import java.util.List;

public class L163MissingRanges {
    /**
     * find the range between lower and first element in the array
     * find range between adjacent elements in the array
     * find the range between upper and last element in the array
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges (int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(formRange(lower, upper));
            return result;
        }
        if (nums[0] > lower) {
            result.add(formRange(lower, nums[0] - 1));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1) {
                result.add(formRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    private String formRange (int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}
