import java.util.ArrayDeque;
import java.util.Queue;

public class Y1091ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix (int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] direction = {
                {1, -1}, {1, 0}, {1, 1},
                {0, -1}, {0, 1},
                {-1, -1}, {-1, 0}, {-1, 1}
        };

        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return res + 1;
                }
                for (int k = 0; k < 8; k++) {
                    int nextX = direction[k][0] + cur[0];
                    int nextY = direction[k][1] + cur[1];

                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                    && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
