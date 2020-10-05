public class C13LongestAscendingSubsequence {
    /*
    {5, 2, 6, 3, 4, 7, 5}
    base case: M[0] = 1
    induction: M[i] represents from the 0-th element to the i-th element
    the value of the longest ascending subsequences (including i-th element)
    M[i] = max[M[j]] + 1                if a[i] > a[j] and 0 <= j < i
            i                           if there is no such j
    Time: O(n ^ 2)
    Space: O(n)
     */
    public int longest (int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] longest = new int[array.length];
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            longest[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    longest[i] = Math.max(longest[j] + 1, longest[i]);
                }
            }
            result = Math.max(longest[i], result);
        }
        return result;
    }
}
