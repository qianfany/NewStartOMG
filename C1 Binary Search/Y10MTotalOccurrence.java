public class Y10MTotalOccurrence {
    public int totalOccurrence (int[] array, int target) {
        int first = firstOccur(array, target);
        if (first == -1) {
            return 0;
        }
        int last = lastOccur (array, target);
        return last - first + 1;
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

}
