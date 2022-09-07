public class L153FindMinInRotatedSortedArray {
    /**
     * No duplication
     * Binary Search
     *
     *      4   5   6   7   0   1   2
     *      l           m           h
     *                  m > 2       l = m + 1
     *                      l   m   h
     *                          m < h   h = m
     *                      l   h       terminate
     *                      return l
     *
     *      11      13      15      17
     *      l       m               h
     *              m < h       h = m
     *              terminate
     *              return l
     *
     *
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
