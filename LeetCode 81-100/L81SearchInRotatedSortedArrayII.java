public class L81SearchInRotatedSortedArrayII {
    /*
    contain duplicates
    Binary search
    Time: O(log n)
    Space: O(1)
     */
    public boolean search (int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] == target) {
                return true;
            }
            // if left part is sorted
            if (nums[left] < nums[mid]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            else {
                left++;
            }
        }
        return false;
    }
}
