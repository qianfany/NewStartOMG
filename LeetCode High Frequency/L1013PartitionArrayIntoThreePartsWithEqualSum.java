public class L1013PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum (int[] sticks, int sides) {
        int sum = 0;
        for (int n : sticks) sum += n;
        if (sum % sides != 0) return false;
        if (sticks.length < sides) return false;

        return canPartition(sticks, new boolean[sticks.length], 0, sides, 0, sum / sides);
    }

    private boolean canPartition(int[] nums, boolean[] used, int start, int k, int curSum, int subSum) {
        if (k == 1) return true;
        if (curSum > subSum) return false;
        if (curSum == subSum) return canPartition(nums, used, 0, k - 1, 0, subSum);

        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            if (canPartition(nums, used, i + 1, k, curSum + nums[i], subSum)) return true;
            used[i] = false;
        }

        return false;

    }
}
