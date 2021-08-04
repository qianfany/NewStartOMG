public class L42连续字数组的最大和 {

    public int maxSubArray (int[] nums) {
        int result = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(prev + nums[i], nums[i]);
            result = Math.max(result, prev);
        }
        return result;
    }

    public int maxSubArrayI (int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1] + nums[i], nums[i]);
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
