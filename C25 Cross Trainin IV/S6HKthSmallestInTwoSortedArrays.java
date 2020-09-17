public class S6HKthSmallestInTwoSortedArrays {
    /**
     * three base cases:
     * 1. we already eliminate all the elements in a
     * 2. we already eliminate all the elements in b
     * 3. when k is reduced to 1
     *
     * we compare the k/2 th element in a's subarray
     * and the k/2 th element in b's subarray
     * to determine which k/2 partition can be surely included
     * in the smallest k elements
     *
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
