public class L153FindMinInRotatedSortedArray {
    /**
     * No duplication
     * Time: O(log n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int findMin (int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) /2;
            if (nums[mid] < nums[high]) {
                high = mid;
                // min is the left part including mid
            }
            else if (nums[mid] > nums[high]) {
                low = mid + 1;
                // min is the right part not including mid
            }
        }
        return nums[low];
    }
}
