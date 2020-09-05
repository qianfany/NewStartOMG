public class JZ23VerifyBSTByPostOrder {
    /*
    Post-Order  [left][right][root]
                            15
                         /      \
                        10      20
                      /   \    /   \
                     8    12  16    25
     8  12  10  16  25  20  15
       [8   12  10]     15  [16   25    20]
       root = post[end]
       all left nodes are smaller than root
       all right nodes are greater than root
       [8]  10  [12]          [16]  20  [25]

       base case: start >= end      return true

     */
    public boolean verify (int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return splitCheck (sequence, 0, sequence.length - 1);
    }

    private boolean splitCheck (int[] post, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = post[end];
        int i;
        for (i = start; i < end; i++) {
            if (post[i] > root) {
                break;
            }
        }
        int j = i;
        while (j < end) {
            if (post[j] < root) {
                return false;
            }
            j++;
        }
        return splitCheck(post, start, i - 1) && splitCheck(post, i, end - 1);
    }
}
