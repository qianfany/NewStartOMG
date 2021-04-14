public class L198RobHouse {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] curMax = new int[nums.length + 1];
        curMax[0] = 0;
        curMax[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax[i + 1] = Math.max(curMax[i], curMax[i - 1] + nums[i]);
        }
        return curMax[nums.length];
    }
}
