public class Y5PerfectSquare {
    /*
    dp[0] = 0
    dp[1] = dp[0]+1 = 1
    dp[2] = dp[1]+1 = 2
    dp[3] = dp[2]+1 = 3
    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
          = Min{ dp[3]+1, dp[0]+1 }
          = 1
    dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
          = Min{ dp[4]+1, dp[1]+1 }
          = 2
                            .
                            .
                            .
    dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
           = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
           = 2
                            .
                            .
                            .
    dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
    */
    public int numSquares (int n) {
        int[] M = new int[n + 1];
        M[1] = 1;
        for (int i = 2; i <= n; i++) {
            M[i] = i;
            for (int j = 1; j * j <= i; j++) {
                M[i] = Math.min(M[i], 1 + M[i - j * j]);
            }
        }
        return M[n];
    }
}
