public class JZ52正则表达式匹配 {
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
    public boolean match (char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i ++) {
            if(pattern[i - 1] == '*') dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j < dp[0].length; j ++) {
                if(pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) dp[i][j] = dp[i - 1][j - 1];
                else if(pattern[j - 1] == '*') {
                    if(pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.') dp[i][j] = dp[i][j - 2];
                    else dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                }
            }
        }
        return dp[str.length][pattern.length];
    }
}
