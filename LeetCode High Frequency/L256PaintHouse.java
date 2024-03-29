public class L256PaintHouse {

    public int minCost (int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int length = costs.length;
        int[][] dp = new int[length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[length - 1][0], Math.min(dp[length - 1][1], dp[length - 1][2]));
    }
}
