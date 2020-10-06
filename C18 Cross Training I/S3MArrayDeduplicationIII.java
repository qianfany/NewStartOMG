import java.util.Arrays;

public class S3MArrayDeduplicationIII {
    /*
    remove duplicated and adjacent letters repeatedly
    1 2 2 2 3
    1       2       2       2       3
    1
    1  set flag
    1       3

    initialize f = 1, s = 0
    for each step
    if there is duplicate, set flag and do nothing
    if array[i] == array[slow], and flag is set
        array[slow] should not be included in the valid subarray
        we can just replace it with array[i] since next we are going to check if
        there is any duplicate of array[i]
        reset flag to false since we are processing another element now
    if array[i] != array[slow] and flag is not set
        it means there is no duplicate of array[end] and it should be included in the valid subarray

     */
    public int[] dedup (int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;
        boolean flag = false;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[slow]) {
                flag = true;
            } else if (flag == true) {
                array[slow] = array[i];
                flag = false;
            } else {
                slow++;
                array[slow] = array[i];
            }
        }
        // check if there is any duplicates for the last elements
        return Arrays.copyOf(array, flag ? slow : slow + 1);
    }
}
