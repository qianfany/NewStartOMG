public class L5LongestPalindromicSubstring {
    /*
    2D
    Dynamic Programming:

    j/i     b       a       b       a       d
    b       1       0       1       0       0

    a               1       0       1       0

    b                       1       0       0

    a                               1       0

    d                                       1

    Time: O(N^2)
    Space: O(N^2)
     */
    public String longestPalindrome (String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int start = 0, end = 0, max = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
                if (dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
