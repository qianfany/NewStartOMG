public class L363MaxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] ps = PrefixSum(matrix);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int x = i; x < matrix.length; x++) {
                    for (int y = j; y < matrix[0].length; y++) {
                        if (i == 0 && j == 0) {
                            sum = ps[x][y];
                            if (sum <= k) {
                                max = Math.max(max, sum);
                            }
                        }
                        else if (i == 0) {
                            sum = ps[x][y] - ps[x][j - 1];
                            if (sum <= k) {
                                max = Math.max(max, sum);
                            }
                        }
                        else if (j == 0) {
                            sum = ps[x][y] - ps[i - 1][y];
                            if (sum <= k) {
                                max = Math.max(max, sum);
                            }
                        }
                        else {
                            sum = ps[x][y] + ps[i - 1][j - 1] - ps[i - 1][y] - ps[x][j - 1];
                            if (sum <= k) {
                                max = Math.max(max, sum);
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    private int[][] PrefixSum (int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int M[][] = new int[R][C];
        M[0][0] = matrix[0][0];

        for (int i = 1; i < C; i++) {
            M[0][i] = M[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < R; i++) {
            M[i][0] = M[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                M[i][j] = M[i - 1][j] + M[i][j - 1] - M[i - 1][j - 1] + matrix[i][j];
            }
        }
        return M;
    }
}
