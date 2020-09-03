import java.util.LinkedList;
import java.util.Queue;

public class C4NumberOfIslands {
    /*
    Data Structure: BFS1
    maintain a Queue and a 2d matrix for deduplication
    linear scan the 2d grid, if a node contains a '1',
    then do bfs, put it into the queue and set the visited to true
    Iteratively search the neighbors of enqueued nodes until the queue
    becomes empty

    Time: O(mn) m: No. rows     n: No. cols
    Space: O(Min(M, N))
     */
    class Node {
        int row;
        int col;
        public Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands (char[][] grid) {
        int h = grid.length;;
        if (h == 0) return 0;
        int l = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    queue.add(new Node(i, j));
                    BFS(queue, grid, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void BFS (Queue<Node> queue, char[][] islandGrid, boolean[][] visited) {
        int H = islandGrid.length;
        int L = islandGrid[0].length;

        while (queue.isEmpty() == false) {
            Node x = queue.poll();
            int row = x.row;
            int col = x.col;

            if (row < 0 || col < 0 || row > H || col > L || visited[row][col]
                    ||islandGrid[row][col] != '1') {
                continue;
            }
            visited[row][col] = true;
            queue.offer(new Node(row, col - 1));
            queue.offer(new Node(row, col + 1));
            queue.offer(new Node(row + 1, col));
            queue.offer(new Node(row - 1, col));
        }
    }
}
