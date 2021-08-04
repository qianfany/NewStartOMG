public class Y10GetMatrixChain {

    public int getMatrixChain (int[] p) {
        return MatrixChainOrder(p, 1, p.length - 1);
    }

    private int MatrixChainOrder (int p[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(p, i, k)
                    + MatrixChainOrder(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];
            if (count < min) {
                min = count;
            }
        }
        return min;
    }
    public static void main(String args[])
    {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        int n = arr.length;
        Y10GetMatrixChain sol = new Y10GetMatrixChain();
        System.out.println(
                "Minimum number of multiplications is "
                        + sol.getMatrixChain(arr));
    }
}
