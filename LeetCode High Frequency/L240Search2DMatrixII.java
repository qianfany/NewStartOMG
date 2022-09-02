public class L240Search2DMatrixII {
    /*
    start from the bottom left
    row & column
    matrix[row][column] > target
        row --
    matrix[row][column] < target
        column++
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length){
            if (matrix[row][col] > target){
                row--;
            } else if (matrix[row][col] <target){
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
