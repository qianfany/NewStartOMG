public class S3LargestSquareSurroundedBy1 {
    /*
    1. fill in two 2D M1[n][n] (right -> left) and M2[n][n] (bottom -> top)       --O(n^2)
    2. for (i)
            for (j) {
                for each possible edge length (min(M1[i][j], M2[i][j]) down to 1) {
                   check leftRight by scan through row  (down - > up)
                   check TopDown by scan through column (right -> left)
                }
            }
        return global_max
        Time = O(n^2) + O(n^2 * n) = O(n^n)
     */
    public int largestSquareSurroundedByOne (int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int globalMax = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] mLeftRight = leftToRight(matrix, row, col);
        int[][] mUpDown = upToDown(matrix, row, col);

        for (int i = row - 1; i >= 0; i--) {
            for (int j= col - 1; j >= 0; j--) {
                int length = Math.min(mLeftRight[i][j], mUpDown[i][j]);
                for (int k = length; k >= 1; k--) {
                    if (mLeftRight[i - (k - 1)][j] >= k && mUpDown[i][j - (k - 1)] >= k) {
                        globalMax = Math.max(globalMax, k);
                        break;
                    }
                }
            }
        }
        return globalMax;
    }

    private int[][] leftToRight(int[][] matrix, int row, int col) {
        int[][] M = new int[row][col];
        for (int i = 0; i < row; i++) {
            M[i][0] = matrix[i][0];
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    M[i][j] = M[i][j - 1] + 1;
                }
            }
        }
        return M;
    }

    private int[][] upToDown(int[][] matrix, int row, int col) {
        int[][] M = new int[row][col];
        for (int j = 0; j < col; j++) {
            M[0][j] = matrix[0][j];
            for (int i = 1; i < row; i++) {
                if (matrix[i][j] == 1) {
                    M[i][j] = M[i - 1][j] + 1;
                }
            }
        }
        return M;
    }
}
