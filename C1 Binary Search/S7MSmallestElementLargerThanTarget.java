public class S7MSmallestElementLargerThanTarget {
    /*
    narrow the range into only two element
    if array[mid] <= target 		left = mid + 1
    else 				right = mid
    Post Process, check left first
    Time: O(log n)				Space: O(1)
     */
    public int smallestElementLargerThanTarget (int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right -left) /2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (array[left] > target) {
            return left;
        }
        if (array[right] > target) {
            return right;
        }
        return -1;

    }
}
