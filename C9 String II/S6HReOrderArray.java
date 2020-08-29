public class S6HReOrderArray {
    /*
    N1, N2, N3 ... N2k ---> N1, Nk+1, N2, Nk+2 ... Nk, N2k

        A   B   C   D   E   F   G   1   2   3   4   5   6   7
        l           lm              m           rm          r

        A   B   C   1   2   3   D   E   F   G   4   5   6   7
        l   lm      m   rm  r

        A   1   B   C   2   3
                l           r

                B   2   C   3

     log 2 (n) levels  ---> total time = O(n log n)
     Space: O(log n)
     */
    public int[] reOrder (int[] array) {
        if (array.length % 2 == 0) {
            reOrder (array, 0, array.length - 1);
        } else {
            reOrder (array, 0, array.length - 2);
        }
        return array;
    }

    private void reOrder (int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse (array, lmid, mid - 1);
        reverse (array, mid, rmid - 1);
        reverse (array, lmid, rmid - 1);

        reOrder(array, left, left + (lmid - left ) * 2 - 1);
        reOrder(array, left + (lmid - left) * 2, right);
    }

    private  void reverse (int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
