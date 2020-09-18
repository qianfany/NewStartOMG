public class L81SearchInRotatedSortedArrayII {
    /*
    contain duplicates
    Binary search
    Time: O(log n)
    Space: O(1)
     */
    public boolean search (int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) /2;
            if (array[mid] == target) {
                return true;
            }
            // if left part is sorted
            if (array[left] < array[mid]) {
                if (array[mid] > target && target >= array[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (array[left] > array[mid]) {
                if (target > array[mid] && target <= array[right]) {
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
