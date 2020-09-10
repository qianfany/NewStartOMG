public class L62UniquePaths {
    /*
    dynamic Programming
            1       1       1       1       1       1
    1       2       3       4       5       6       7

    1       3       6       10      .......

    1       .
            .
    1       .

    1

    base case: dp[0][0] = 0  dp[i][0] = 1 dp[0][j] = 1
    induction rule: dp[i][j] = dp[i][j-1] + dp[i-1][j]
    Time: O(n*m)
    Space: O(n*m)
     */
    public int uniquePath (int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i- 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
