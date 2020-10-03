public class S2HLongestCrossOf1s {
    /*
    solution 0:
    for for (i,j) {
        we run 4 for loops to check each direction
    }
    Time: O(n^3)

    Solution 1: (DP)        M1 left - > right   M2 right - > left
      0  1  0  0            0  1  0  0          0  1  0  0
      1  1  1  1            1  2  3  4          4  3  2  1
      0  1  0  0            0  1  0  0          0  1  0  0
      0  1  0  0            0  1  0  0          0  1  0  0
    M3 top - > bottom       M4 bottom - > top
      0  1  0  0            0  4  0  0
      1  2  1  1            1  3  1  1
      0  3  0  0            0  2  0  0
      0  4  0  0            0  1  0  0
    left Up


      for each element in the input matrix
      M[i][j] = min (M1[i][j], M2[i][j], M3[i][j], M4[i][j])
      return global_max among all M[i][j]
      Time = O(4 * n^2 + n^2) = O(n^2)

     */
    public int largest(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }
        int[][] leftUp = leftUp(matrix, N, M);
        int[][] rightDown = rightDown(matrix, N, M);
        return merge (leftUp, rightDown, N, M);
    }

    private int merge (int[][] leftUp, int[][] rightDown, int N, int M) {
        int result = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    private int[][] leftUp (int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0){
                        up[i][j] = 1;
                        left[i][j] = 1;
                    } else if (i == 0) {
                        up[i][j] = 1;
                        left[i][j] = left[i][j - 1] + 1;
                    } else if (j == 0) {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = 1;
                    } else {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        merge (left, up, N, M);
        return left;
    }

    private int[][] rightDown (int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];
        int[][] down = new int[N][M];
        for (int i = N - 1; i >= 0; i--){
            for (int j = M - 1; j >= 0; j--){
                if (matrix[i][j] == 1) {
                    if (i == N - 1 && j == M - 1) {
                        down[i][j] = 1;
                        right[i][j] = 1;
                    } else if (i == N - 1) {
                        down[i][j] = 1;
                        right[i][j] = right[i][j + 1] + 1;
                    } else if (j == M - 1) {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = 1;
                    } else {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        merge(right, down, N, M);
        return right;
    }
}














