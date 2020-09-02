import java.util.*;

public class S2ECommonNumbersOfTwoArraysII {
    /*
    two pointers
    sort both array first, then do small and move
    Time: O(n log n)
    Space: O(1)
     */
    public List<Integer> common (int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                list.add(A[i]);
                i++; j++;
            }
            else if (A[i] > B[j]) {
                j++;
            } else {
                i++;
            }
        }
        return list;
    }
}
