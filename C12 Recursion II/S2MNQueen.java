import java.util.ArrayList;
import java.util.List;

public class S2MNQueen {
    /*
    Level by Level
                                root = 0 queen
                          /        |       |       |       |       |       |
level 1             Q0 (0, 0)   (0, 1)   (0, 2)                            (0,7)
                  /||||||||\
level 2         (1,0) .....(1,7)
Time = O(8 ^ 8 * 8)  -> O(n^n * n)          -> O(n!)

        check valid:
        base case: The last row is done, 0 row left
        recursive rule: iff position(i,j) valid -> go to the next row (i + i)
     */
    public void nQueens (int n) {
        List<List<String>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs (n, cur);
    }

    private void dfs (int n, List<Integer> cur) {
        if (cur.size() == n) {
            System.out.println(cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid (cur, i)) {
                cur.add(i);
                dfs(n, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid (List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        S2MNQueen sol = new S2MNQueen();
        sol.nQueens(8);
    }
}
