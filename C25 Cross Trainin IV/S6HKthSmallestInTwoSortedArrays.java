public class S6HKthSmallestInTwoSortedArrays {
    /**
     Q6. Kth Closest Element in Two Sorted Arrays
     Solution 1:
     A[] = {2, 5, 7, 10, 13}
     B[] = {1, 3, 4, 13, 20, 29}
     k = 5, linear scan, Time O(k)

     solution 2: Binary search:
     We compare the k/2 th lament in a’s subarray and the k/2 th element in b’s subarray,
     to determine which k/2 partition can be surely included in the smallest k elements
     Divide and Conquer
     if (X <= Y)
     A[] = xxxxxxxxxxxxx X  [xxxxxxxxxxxxxxx
     B[] = yyyyyyyyyyyyy] Y yyyyyyyyyyyyyyy
     else
     A[] = xxxxxxxxxxxxx] X xxxxxxxxxxxxxxx
     B[] = yyyyyyyyyyyyy Y [yyyyyyyyyyyyyyy
     Three base cases:
     already eliminate all the elements in a
     already eliminate all the elements in b
     when k is reduced to 1
     Time: O(log k)					Space: O(log k)
     */
    public int kth (int[] a, int[] b, int k) {
        return kth (a, 0, b, 0, k);
    }

    private int kth (int[] a, int aleft, int[] b, int bleft, int k) {
        if (aleft >= a.length) {
            return b[bleft + k - 1];
        }
        if (bleft >= b.length) {
            return a[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }
        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if (aval <= bval) {
            return kth(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return kth(a, aleft, b, bmid + 1, k - k / 2);
        }
    }
}
