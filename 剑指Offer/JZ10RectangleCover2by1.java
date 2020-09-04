public class JZ10RectangleCover2by1 {
    /*
    f(0) = 0;

    f(1) = 1
    f(2) = 2
    f(3) = 3
    f(n) = f(n-1) + f(n-2)
    Dynamic Programming
    Time: O(n)
    Space: O(n)
     */

    public int rectCover (int target) {
        if (target <= 0 ) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[target];
    }
}
