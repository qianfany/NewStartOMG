import java.util.HashMap;
import java.util.Map;

public class S3LabyrinthEscape {

    class Pair {
        int a;
        int b;
        public Pair (int a , int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int hashCode() {
            return 31 * 31 * this.a + 31 * this.b;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair another = (Pair) obj;
            return this.a == another.a && this.b == another.b;
        }
    }

    private Map<Pair, Pair> map;
    public boolean canEscape (int n, int m, int[][] obstacles, int[][] teleports) {
        map = new HashMap<>();
        for (int[] tele : teleports) {
            map.put(new Pair(tele[0], tele[1]), new Pair(tele[2], tele[3]));
        }
        int[][] matrix = new int[n][m];
        for (int[] block : obstacles) {
            matrix[block[0]][block[1]] = 1;
        }
        int i = 0, j = 0;
        while ( i <= n  && j <= m - 1) {
            if (matrix[i][j] == 1) {
                return false;
            }
            if (map.containsKey(new Pair(i, j))) {
                Pair cool = map.get(new Pair(i, j));
                i = cool.a;
                j = cool.b;
                continue;
            }
            j++;
        }
        if (j >= m -1) {
            return i == n - 1;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        S3LabyrinthEscape sol = new S3LabyrinthEscape();
        int[][] obstacles = {{2, 1}};
        int[][] teleports = {{0, 1, 2, 1}};
        System.out.println(sol.canEscape(3, 3, obstacles, teleports));
    }
}
