public class L74Search2DMatrix {
    /*
    expand the 2D matrix into an 1D array
    row, col.
    left = 0, right = row * col - 1
    locate by matrix[mid/col][mid%col]
    Do binary search

    Time: O(log n*m)
    Space: O(1)
     */
    public boolean searchMatrix (int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int left = 0;
        int right = rowNum * colNum -1;

        while(left <= right){
            int mid = left + (right - left) /2;
            if (matrix[mid / colNum][mid % colNum] == target){
                return true;
            }
            else if (matrix[mid / colNum][mid % colNum] > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;

    }
}
