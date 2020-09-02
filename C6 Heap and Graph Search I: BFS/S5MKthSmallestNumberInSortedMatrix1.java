import java.util.Comparator;
import java.util.PriorityQueue;

public class S5MKthSmallestNumberInSortedMatrix1 {
    /*
               1    3    5    7
               2    4    8    9
               3    5    11   15
               6    8    13   18

    Data Structure Priority Queue
    Algorithm: BFS2 best first search
        1. initial state (start node): input[0][0]
        2. Node expansion/Generation:
            expand node[i][j]
                generate [i + 1][j]
                generate [i][j + 1]
        3. Termination condition:
            when the kth element is popped out of expansion
        4. deduplication: boolean[][] generated set [i][j] = true

        Time: O(k * log k)
        Space: O(k + n * n)
        extra space can be optimized to O(k) using a hash Set

     */
    public class Cell {
        int row; int column; int value;
        Cell (int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
    public int kthSmallest (int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
                minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }
            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    public static void main (String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {2, 4, 8, 9},
                {3, 5, 11, 15},
                {6, 8, 13, 18},
        };
        S5MKthSmallestNumberInSortedMatrix1 sol = new S5MKthSmallestNumberInSortedMatrix1();
        System.out.println(sol.kthSmallest(matrix, 5));
    }
}
