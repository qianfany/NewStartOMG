import java.util.LinkedList;
import java.util.Queue;

public class Y13BestMeetingPoint {

    public int minTotalDistance (int[][] grid) {
        if (grid.length <= 0) return 0;
        if (grid[0].length <= 0) return 0;
        int minDistance = Integer.MAX_VALUE;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int distance = search(grid, row, col);
                minDistance = Math.min(distance, minDistance);
            }
        }
        return minDistance;
    }

    private int search (int[][] grid, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.offer(new Point(row, col, 0));
        int totalDistance = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int r = point.row;
            int c = point.col;;
            int d = point.distance;
            if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c]) {
                continue;
            }
            if (grid[r][c] == 1) {
                totalDistance = totalDistance + d;
            }
            visited[r][c] = true;
            queue.offer(new Point(r+1, c, d + 1));
            queue.offer(new Point(r-1, c, d + 1));
            queue.offer(new Point(r, c+1, d + 1));
            queue.offer(new Point(r, c-1, d + 1));
        }
        return totalDistance;
    }


    class Point {
        int row, col, distance;
        public Point (int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
