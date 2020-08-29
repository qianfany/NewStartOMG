import java.util.Arrays;

public class S1MKSmallestInUnsortedArrayQuickSelect {
    /*
    quick select
    quick select to find the kth smallest element
    after calling this method, the first k elements in the array are
    the k smallest ones (but not sorted)

    1. like quick sort, we need to do the partition using pivot value
    2. unlike quick sort, we only need to do quick select on at most one
    partition
    3. if the pivot is already the kth smallest element, we can directly return

    if the kth smallest one is in the left partition
        recursively call quick select on the left partition
    otherwise
        recursively call on the right partition

    Time: O(n)
    Space: O(log n)
     */
    public int[] kSmallestII (int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        quickSelect (array, 0, array.length - 1, k - 1);
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    private void quickSelect (int[] array, int left, int right, int target) {
        int mid = partition(array, left, right);
        if (mid == target) {
            return;
        } else if (target < mid) {
            quickSelect(array, left, mid - 1, target);
        } else {
            quickSelect(array, mid + 1, right, target);
        }
    }

    private int partition (int[] array, int left, int right) {
        int pivot = array[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (array[end] >= pivot) {
                end--;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, start, right);
        return start;
    }
    private void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
