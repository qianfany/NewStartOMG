import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90SubsetsII {

    public List<List<Integer>> subsetsWithDup (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        helper (nums, list, 0, result);
        return result;
    }

    private void helper (int[] nums, List<Integer> list, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        helper(nums, list, index + 1, result);
        list.remove(list.size() - 1);
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index ++;
        }
        helper(nums, list, index + 1, result);
    }
}
