public class L59SpiralMatrixII {
    /*
    can be use for matrix m * n
                    1
                ---------->
                |         |
              4 |         |  2
                |         |
                <----------
                    3
    Time: O(n^2)
    Space: O(1)
     */
    public int[][] generateMatrix (int n) {
        int[][] matrix = new int[n][n];

        if (n == 0) {
            return matrix;
        }

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num; //change
                num++;
            }
            rowStart ++;

            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num; //change
                num++;
            }
            colEnd --;

            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num; //change
                num++;
            }
            rowEnd --;

            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num; //change
                num++;
            }
            colStart ++;
        }

        return matrix;
    }
}
