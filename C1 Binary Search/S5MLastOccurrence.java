public class S5MLastOccurrence {
    public int lastOccur (int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) /2;
            // if target = array[mid] this could be set as the
            // left boundary
            if (array[mid] <= target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        // right first
        if (array[right] ==target) {
            return right;
        }
        if (array[left] == target) {
            return left;
        }
        return -1;
    }
}
