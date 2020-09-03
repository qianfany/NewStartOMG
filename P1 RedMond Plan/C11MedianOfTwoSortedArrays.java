public class C11MedianOfTwoSortedArrays {
    /*
    x ->        x1  x2 | x3  x4  x5  x6
    y ->        y1  y2  y3  y4  y5 | y6  y7  y8
                    x2 <= y6
                    y5 <= x3        -> median = avg (max(x2, y5), min(x3, y6))
                                           or = max(x2, y5)
    find the partition using binary search
    time: O(log (min(x, y)))

     */
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(a, 0, b, 0, l) + getKth(a, 0, b, 0, r)) / 2.0;
    }

    public double getKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;

        if (aStart + k/2 - 1 < A.length) {
            aMid = A[aStart + k/2 - 1];
        }
        if (bStart + k/2 - 1 < B.length) {
            bMid = B[bStart + k/2 - 1];
        }

        if (aMid < bMid)
            return getKth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getKth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
}
