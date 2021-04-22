public class L19正则表达式匹配 {
    /*
    . matches any single character
    * matches zero or more of the preceding element

    case 1: p[j] == s[i]
                dp[i][j] = dp[i - 1][j - 1]
    case 2: p[j] == '.'
                dp[i][j] = dp[i - 1][j - 1]
    case 3: p[j] == '*'
            3.1: p[j - 1] != s[i]
                dp[i][j] = dp[i][j-2]
                (a* counts as empty)
            3.2: p[i - 1] == s[i] or p[i - 1] == '.'
                3.2.1: dp[i][j] = dp[i - 1][j]
                        a* counts as multiple a
                3.2.2: dp[i][j] = dp[i][j - 1]
                        a* counts as single a
                3.2.3: dp[i][j] = dp[i][j - 2]
                        a* counts as empty
    i/j     #       c       *       a       *       b
    #       1       0       1       0       1       0

    a       0       0       0       1       1       0

    a       0       0       1       1       1       0

    b       0       0       0       1       1       1

    Time:   O(s.length * p.length)
    Space:  O(s.length * p.length)
     */
    public boolean isMatch (String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // case 1 and 2
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    // 3.1 (count as empty)
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                    // 3.2 (three cases)
                    else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j+1] || dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
