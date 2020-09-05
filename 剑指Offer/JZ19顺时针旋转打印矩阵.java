import java.util.ArrayList;
import java.util.List;

public class JZ19顺时针旋转打印矩阵 {
    /*
    Spiral order traverse general case
    1. go right
    2. go down
    3. go left
    4. go up
    for boundaries --
    if left == right    print from up to down
    if up == down       print from left to right
    Time:   O(n * m)
    Space:  O(n * m)
     */
    public ArrayList<Integer> printMatrix (int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = n -1;
        int up = 0;
        int down = m -1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down -1; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right; i>= left; i--) {
                list.add(matrix[down][i]);
            }
            for (int i = down -1; i >= up+ 1; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        if(left > right || up > down) {
            return list;
        }
        if ( left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][left]);
            }
        } else {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
        }
        return list;
    }
}
