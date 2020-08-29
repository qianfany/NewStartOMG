public class S2ELongestAscendingSubArray {

    /*
    base case: only one element M[0] = 1
    induction rule: define the solution relationship from the smaller problem to the larger problem
    M[i] represents [within the range from the beginning to the i-th element] the max length
    of the ascending subarray
    M[i] = M[i - 1] + 1                         if input[i - 1] < input[i]
         = 1                                    otherwise
         Time: O(n)
         Space: O(n)    ->O(1)
     */
    public int longest (int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int result = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur++;
                result = Math.max(result, cur);
            }
            else {
                cur = 1;
            }
        }
        return result;
    }
}
