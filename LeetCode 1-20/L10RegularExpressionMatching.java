public class L10RegularExpressionMatching {
    /*
    "." matches any single character
    "*" matches zero or more of the preceding element
    case 1: p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i - 1][j - 1]
    case 2: p.charAt(j) == '.'  : dp[i][j] = dp[i -1][j-1]
    case 3:
         3.1 :  if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]
         a* in this case counts as empty
         3.2 :  if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == "."
            1. a* counts as multiple a      dp[i][j] = dp[i -1][j]
            2. a* counts as single a        dp[i][j] = dp[i][j-1]
            3. a* counts as empty           dp[i][j] = dp[i][j-2]

        #       m       i       s       s       s       s       s
    #   1       0       0       0       0       0       0       0

    m   0       1       0       0       0       0       0       0

    i   0       0       1       0       0       0       0       0

    s   0       0       0       1       0       0       0       0

    *   0       0       0       1       1       1       1       1

    .   0       0       0       0       1       1       1       1

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
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                    else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j+ 1] || dp[i + 1][j -1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
