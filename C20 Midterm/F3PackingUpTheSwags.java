public class F3PackingUpTheSwags {

//  Lease number of Square sum
//  Dynamic Programming
//  dp[i] = min # perfect squares needed to sum to i
//  base case: dp[0] = 0 dp[1] = 1
//  dp[10] = dp[10- 3*3] + 1
//  induction rule: dp[i] = min(dp[i - j*j] + 1, dp[i])
//
//  time: O(nlogn)
//  Space: O(n)    n = num
    public int minBox (int num) {

        int[] dp = new int[num + 1];
        dp[1] = 1;
        for (int i = 2; i < num; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[num];
    }
}
