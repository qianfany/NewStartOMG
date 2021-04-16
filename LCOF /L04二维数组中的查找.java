import java.util.LinkedList;
import java.util.Queue;

public class L04二维数组中的查找 {
    /*
    BFS
    queue
     */
    public boolean findNumberIn2DArray (int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int colLen = matrix[0].length;
        int rowLen = matrix.length;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if (matrix[cur.row][cur.col] == target) {
                    return true;
                } else if (matrix[cur.row][cur.col] < target) {
                    if (cur.row <= rowLen - 2) {
                        queue.offer(new Pair(cur.row + 1, cur.col));
                    }
                    if (cur.col <= colLen - 2) {
                        queue.offer(new Pair(cur.row, cur.col + 1));
                    }
                }
            }
        }
        return false;
    }

    private class Pair {
        int row, col;
        private Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /*
    Start from bottom left
     */

    public boolean findNumberIn2DArrayII (int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
