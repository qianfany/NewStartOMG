public class S5HLargestSquareOf1s {
    /*
    M[i][j] represents the max size of square with (i, j) as the bottom right corner
    M[i][j] = 0                                                 if A[i][j] == 0
            = min(M[i-1][j-1], M[i-1][j], M[i][j -1]) + 1     otherwise
    Time:   O(n^2)
    Space: O(n^2)
     */
    public int Largest (int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int result = 0;
        int[][] largest = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    largest[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.min(Math.min(largest[i][j - 1] + 1,
                            largest[i - 1][j] + 1), largest[i - 1][j - 1] + 1);
                }
                result = Math.max(result, largest[i][j]);
            }
        }
        return result;
    }
}
