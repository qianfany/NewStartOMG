import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15ThreeSum {

    /*
    Assumptions: array is not null, array.length >= 3
    sort the array
    Three pointer
    Our goal is to find i < j < k, such that
    array[i] + array[j] + array[k] = 0
    get all the result of possible sum
    To make sure there is no duplicate triple
    we ignore all the duplicate possible i.
    first 2 will be selected as i
    if (nums[i] + nums[j] + nums[k] < 0) left++
    if (nums[i] + nums[j] + nums[k] > 0) right--
    if (nums[i] + nums[j] + nums[k] == 0))  result.add  if nums[j] == nums[j-1] j++ until different
    Time: O(n^2)
    Space: O(1)
     */
    public List<List<Integer>> allTriples (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp + nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (tmp + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
