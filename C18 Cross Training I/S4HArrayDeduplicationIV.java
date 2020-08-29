import java.util.Arrays;

public class S4HArrayDeduplicationIV {
    /*
    unsorted array
    1 2 3 3 3 2 2 - > 1 2 2 2 -> 1 return 1
    Initialize: s = -1 f = 0
    for each step
        s == -1 || array[s] != array[f]
            s++, array[s] = array[f]
        otherwise:
            keep move f until array[f+1] != array[s]
            s --

     */
    public int[] dedup (int[] array) {
        int slow = -1;
        for (int i = 0; i < array.length; i++) {
            if (slow == -1 || array[slow] != array[i]) {
                slow++;
                array[slow] = array[i];
            } else {
                while (i + 1 < array.length && array[i + 1] == array[slow]) {
                    i++;
                }
                slow--;
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
