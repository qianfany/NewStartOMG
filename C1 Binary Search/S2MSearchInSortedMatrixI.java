import java.util.Arrays;

public class S2MSearchInSortedMatrixI {
    /*
    expand the 2D matrix into an 1D array
    row, col.
    left = 0, right = row * col - 1
    locate by matrix[mid/col][mid%col]
    Do binary search
     */
    public int[] search (int[][] matrix, int target) {
        int[] result = {-1, -1};
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (matrix[mid / col][mid % col] == target) {
                result[0] = mid / col;
                result[1] = mid % col;
                return result;
            }
            else if (matrix[mid / col][mid % col] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main (String[] args) {
        S2MSearchInSortedMatrixI sol = new S2MSearchInSortedMatrixI();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(Arrays.toString(sol.search(matrix, 5)));
    }
}
