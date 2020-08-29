public class S2MLargestSubArraySum {
    /*
    Dynamic Programming
    {2, -1, 4, -2, 1}

    OPT (i) represents the largest subarray sum at the array index i (include the index)
    base case: OPT(0) = array[0]
    Induction rule: OPT(i) = Max(array[i] + OPT(i - 1), OPT(i))
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
}
