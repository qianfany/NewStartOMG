import java.util.Arrays;

public class S2MArrayDeduplicationII {
    /*
    remove duplicate with same value at least 3
    data structure
    slow: all elements to the left side of slow (excluding slow) pointer are the result for the elements
    that have been processed
    fast: the current index being processed. (all elements to the right side of the fast pointer have
    not been processed)

    Algorithm:
    Initialize: s = 1, f= 2
    case 1: a[f] == a[s-1]  we are sure a[f] == a[s] not copy   since this array is sorted
    case 2: a[f] != a[s-1], a[s] = a[f]; s++
     */
    public int[] dedup (int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int slow = 1;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                slow++;
                array[slow] = array[fast];
            }
        }
        return Arrays.copyOf(array,slow + 1);
    }
}
