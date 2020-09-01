public class S1ELongestConsecutive1s {
    /*
    Dynamic Programming
    M[i] represents the longest contiguous 1s from the 0-th  element to i-th element
    base case: M[0] = A[0]
    Induction rule
    M[i] = M[i - 1] + 1                     if A[i] == 1
    M[i] = 0                                otherwise
    Time:   O(n)
    Space:  O(1)
     */
    public int longest (int[] array) {
        int result = 0;
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                if (i == 0 || array[i - 1] == 0) {
                    cur = 1;
                } else {
                    cur++;
                }
            }
            result = Math.max(result, cur);
        }
        return  result;
    }
}
