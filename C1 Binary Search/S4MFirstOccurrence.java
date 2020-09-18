public class S4MFirstOccurrence {
    /*
    termination condition: L & R are next to each other, jump out of the while loop
    do post-processing to find the nearest
    Time; O(log n)
    Space: O(1)
     */
    public int firstOccur (int[] array, int target) {
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
        // post process check the left one first
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }
}
