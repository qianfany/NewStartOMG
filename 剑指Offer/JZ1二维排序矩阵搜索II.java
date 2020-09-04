public class JZ1二维排序矩阵搜索II {
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
    public boolean Find (int target, int [][] array) {
        int row = array.length - 1;
        int col = 0;

        while (row >= 0 && col < array[0].length) {
            if (array[row][col] > target) {
                row--;
            }
            else if (array[row][col] < target) {
                col++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
