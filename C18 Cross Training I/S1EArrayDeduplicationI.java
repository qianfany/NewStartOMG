import java.util.Arrays;

public class S1EArrayDeduplicationI {
    /*
    slow: all elements to the left side of the slow (excluding slow) pointer are the results
    for the elements that have been processed
    fast: the current index being processed.
    Initialize slow at 0, fast at 1
    if fast != slow
        fast++
    if fast == slow
        slow++, fast++, array[slow] = array[fast]
     */
    public int[] dedup (int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow]) {
                slow++;
                array[slow] = array[fast];
            }
        }
        return Arrays.copyOfRange(array, 0, slow + 1);
    }
}
