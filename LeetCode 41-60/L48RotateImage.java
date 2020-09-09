public class L48RotateImage {
    /*                                          2 ->
    1   2   3   4   5                   13                  1
    16  17  18  19  6                                       2
    15  24  25  20  7                 1|                    3       3|
    14  23  22  21  8                                       4
    13  12  11  10  9                    9                  5
                                                <- 4
    split into levels and for eac level split it into four partitions

    Time: O(n^2)
    Space: O(1)

     */
    public void rotate (int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        int round = n / 2;

        for (int level = 0; level < round; level++) {
            int left = level;
            int right = n - 2 - level;
            for (int i = left; i <= right; i++) {
                int tmp = matrix[left][i];
                matrix[left][i] = matrix[n - 1 - i][left];
                matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
                matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 -left];
                matrix[i][n- 1 - left] = tmp;
            }
        }
    }
}
