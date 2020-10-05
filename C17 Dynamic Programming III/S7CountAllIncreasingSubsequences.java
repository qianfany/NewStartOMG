import java.util.Arrays;

public class S7CountAllIncreasingSubsequences {
    /**
     * Use Dynamic Programming
     * first compute count of increasing subsequences ending at every index
     * finally return sum of all values
     * {3,  2,  4,  5,  4}
     *  1   1   1   1   1
     *  1   1   3   6   3
     *  count = sum of array before             if a[i] > a[j]
     *  add all result together
     * @param a
     * @return
     */
    public int numIncreasingSubsequences (int[] a) {
        int[] array = new int[a.length];
        Arrays.fill(array, 1);

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    array[i] += array[j];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += array[i];
        }
        return result;
    }
}
