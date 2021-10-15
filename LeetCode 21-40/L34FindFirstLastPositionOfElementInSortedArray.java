public class L34FindFirstLastPositionOfElementInSortedArray {
    /*
    do first occurrence and last occurrence

    time: O(log n)
    Space: O(1)
     */
    public int[] searchRange (int[] nums, int target) {
        int[] result = new int[2];
        result[0] = firstOccur(nums, target);
        result[1] = lastOccur(nums, target);
        return result;
    }

    private int firstOccur (int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) /2;
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }
    private int lastOccur (int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) /2;
            if (array[mid] <= target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (array[right] ==target) {
            return right;
        }
        if (array[left] == target) {
            return left;
        }
        return -1;
    }
    public int[] searchRangeI (int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        ans[0] = binarySearch(nums, target, true);
        ans[1] = binarySearch(nums, target, false);

        return ans;
    }

    public int binarySearch(int[] nums, int target, boolean leftRight) {
        int ans = -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (leftRight) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
