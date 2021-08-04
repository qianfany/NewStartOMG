import java.util.Arrays;

public class S2MLargestSubArraySum {
    /*
    Dynamic Programming
    {2, -1, 4, -2, 1}

    OPT (i) represents the largest subarray sum at the array index i (include the index)
    base case: OPT(0) = array[0]
    Induction rule: OPT(i) = Max(array[i] + OPT(i - 1), array[i])
    Time(n)
    Space O(n) -> O(1) by only store a previous value and the max value
     */
    public int largestSum (int[] array) {
        int result = array[0];
        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            prev = Math.max(prev + array[i], array[i]);
            result = Math.max(result, prev);
        }
        return result;
    }


    public int[] largestSumII (int[] array) {
        int result = Integer.MIN_VALUE;
        int prev = 0, start = 0, end = 0, s = 0;
        for (int i = 0; i < array.length; i++) {
            prev += array[i];
            if (result < prev) {
                result = prev;
                start = s;
                end = i;
            }
            if (prev < 0) {
                prev = 0;
                s = i  + 1;
            }
        }
        return new int[] {result, start, end};
    }

    public static void main (String[] args) {
        S2MLargestSubArraySum sol = new S2MLargestSubArraySum();
        int[] array = {4, 2, -3, -2, 3, -1, -2, 6};
        System.out.println((sol.largestSum(array)));
    }
}
