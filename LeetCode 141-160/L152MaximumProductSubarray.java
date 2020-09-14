public class L152MaximumProductSubarray {
    /*
    Dynamic Programming: keep track of the min and max value
    base case:
    maxV = array[0], minV = array[0], result = array[0]
    Induction rule:
    max = max (max * array[i], min * array[i], array[i])
    min = min (tempMax * array[i], min * array[i], array[i])
     */
    public int maxProduct (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmpMax * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
