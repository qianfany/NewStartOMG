public class L53maximumSubarray {
    /*
    Dynamic Programming
    {2, -1, 4, -2, 1}

    OPT (i) represents the largest subarray sum at the array index i (include the index)
    base case: OPT(0) = array[0]
    Induction rule: OPT(i) = Max(array[i] + OPT(i - 1), OPT(i))
    Time(n)
    Space O(n) -> O(1) by only store a previous value and the max value
     */
    public int maxSubArray (int[] nums) {
        int result = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(prev + nums[i], nums[i]);
            result = Math.max(result, prev);
        }
        return result;
    }

}
