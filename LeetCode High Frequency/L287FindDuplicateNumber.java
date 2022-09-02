import java.util.HashSet;
import java.util.Set;

public class L287FindDuplicateNumber {
    public int findDuplicate (int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (seen.contains(nums[i])){
                return nums[i];
            }
            seen.add(nums[i]);
        }
        return -1;
    }
}
