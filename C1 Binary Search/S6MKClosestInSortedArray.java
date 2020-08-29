public class S6MKClosestInSortedArray {
    /*
    Use binary search to first find the largest element smaller or equal to target in array
    then go both side check one by one
    Time: O(log n + k)
     */
    public int[] KClosest (int[] array, int target, int k) {
        if (array == null  || array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[0];
        }
        int left = largestSmallerEqual (array, target);
        int right = left + 1;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (right >= array.length || (left >= 0 && target - array[left] <= array[right] -target)) {
                result[i] = array[left];
                left--;
            } else {
                result[i] = array[right];
                right++;
            }
        }
        return result;
    }

    public int largestSmallerEqual (int[] array, int target) {
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
        if (array[right] <= target) {
            return right;
        }
        if (array[left] <= target) {
            return left;
        }
        return -1;
    }
}
