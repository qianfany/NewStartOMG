import java.util.ArrayList;
import java.util.List;

public class S3ECommonNumberOfTwoSortedArrays {
    /*
    sol 1. hashSet
        insert all number in a into hashset - O(m) in average
        find in b common elements - O(n) in average
        Time: O(m + n) in average
        Space: O(n)
    ** Sol 2. two pointer
        Time: O(n + m)
        Space: O(1)
    Sol 3. binary search
        Time: O(m log n) for m << n
        space: O(1)

     */
    public List<Integer> common (int[] A, int[] B) {
        List<Integer> common = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                common.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }


}
