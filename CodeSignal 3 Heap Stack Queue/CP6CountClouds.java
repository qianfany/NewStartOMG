import java.util.LinkedList;
import java.util.Queue;

public class CP6CountClouds {

    class Node {
        int row;
        int col;
        public Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int countClouds (char[][] skyMap) {
        int h = skyMap.length;
        if (h == 0) return 0;
        int l = skyMap[0].length;
        int islands = 0;

        boolean[][] visited = new boolean[skyMap.length][skyMap[0].length];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (!visited[i][j] && skyMap[i][j] == '1') {
                    queue.add(new Node(i, j));
                    BFS(queue, skyMap, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void BFS (Queue<Node> queue, char[][] islandGrid, boolean[][] visited) {
        int H = islandGrid.length;
        int L = islandGrid[0].length;

        while (!queue.isEmpty()) {

            Node x = queue.poll();
            int row = x.row;
            int col = x.col;

            if (row < 0 || col < 0 || row >= H || col >= L || visited[row][col]
                    || islandGrid[row][col] != '1') {
                continue;
            }

            visited[row][col] = true;
            queue.offer(new Node(row, col - 1));
            queue.offer(new Node(row, col + 1));
            queue.offer(new Node(row + 1, col));
            queue.offer(new Node(row - 1, col));
        }
    }

    public static void main (String[] args) {
        CP6CountClouds sol = new CP6CountClouds();
        char[][] skyMap = {
                {'0', '1', '1', '0'},
                {'0', '1', '1', '0'},
                {'1', '0', '0', '1'},
                {'0', '1', '1', '0'},
        };
        System.out.println(sol.countClouds(skyMap));
    }
}
