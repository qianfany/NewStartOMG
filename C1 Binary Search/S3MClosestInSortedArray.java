public class S3MClosestInSortedArray {
    /*
    Binary search
    narrow down to only two elements
    then do post processing to find the closest
     */
    public int closest (int[] array, int target) {
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
        if (Math.abs(array[right] - target) > Math.abs(array[left] - target)) {
            return left;
        }
        return right;
    }
}
