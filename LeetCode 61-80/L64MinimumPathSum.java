public class L64MinimumPathSum {
    /*
      1         3           1               1           4           5
      1         5           1               2           7           6
      4         2           1               6           8           7

      base case:
      dp[0][0] = grid[0][0]
      dp[i][0] = dp[i-1][0] + grid[i][0]
      dp[0][j] = dp[0][j-1] + grid[0][j]
      induction rule:
      dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]

      Time: O(nm)
      SPace: O(nm)
     */
    public int minPathSUm (int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 1; i < m; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}
