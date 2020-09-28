import java.util.*;

public class Y12PlaceToPutChairI {

    static class Node {
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public List<Integer> putChair(char[][] gym) {
        int m = gym.length, n = gym[0].length, count = 0;
        int[][] distance = new int[m][n];
        int[][] reach_equip = new int[m][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] == 'E') {
                    count++;
                    boolean[][] visited = new boolean[m][n];
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    int level = 1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            Node cur = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int x = cur.x + dx[l];
                                int y = cur.y + dy[l];
                                if (x >= 0 && x < m && y >= 0 && y < n && gym[x][y] != 'O' && !visited[x][y]) {
                                    queue.offer(new Node(x, y));
                                    //统一在加入queue时更新状态
                                    visited[x][y] = true;
                                    distance[x][y] += level;
                                    reach_equip[x][y]++;
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] == 'C' && reach_equip[i][j] == count && distance[i][j] < min) {
                    index1 = i;
                    index2 = j;
                    min = distance[i][j];
                }
            }
        }
        if (index1 != -1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(index1);
            ans.add(index2);
            return ans;
        }
        return Arrays.asList(-1, -1);
    }

}
