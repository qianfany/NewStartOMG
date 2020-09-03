public class C10SearchInSortedMatrixII {
    /*
    go from the bottom left,
    case 1: matrix[row][col] > target
        go up
    case 2: matrix[row][col] < target
        go right

    search space reduction
    Time: O(n + m)
    Space: O(1)
     */
    public int[] search (int[][] matrix, int target) {
        int[] result = {-1, -1};
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            }
            else if (matrix[row][col] < target) {
                col++;
            } else {
                result[0] = row;
                result[1] = col;
                break;
            }
        }
        return result;
    }
}
