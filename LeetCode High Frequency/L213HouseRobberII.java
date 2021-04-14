public class L213HouseRobberII {
    /*
    the first and last house are connected
     */
    public int rob (int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));
    }

    private int rob (int[] nums, int start, int end) {
        int preMax = 0, curMax = 0;
        for (int i = start; i <= end; i++) {
            int tmp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = tmp;
        }
        return curMax;
    }
}
