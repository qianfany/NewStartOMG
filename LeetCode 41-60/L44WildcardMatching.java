public class L44WildcardMatching {
    /*
    '?' Matches any single character
    '*' Matches any sequence of characters
    match "abcdbdk" with "*a*b?k"

        #       a       d       c       b       d       k
    #   1       0       0       0       0       0       0

    *   1       1       1       1       1       1       1

    a   0       1       0       0       0       0       0

    *   0       1       1       1       1       1       1

    b   0       0       0       0       1       0       0

    ?   0       0       0       0       0       1       0

    k   0       0       0       0       0       0      (1)  answer

    base case:
    anyone is empty, return false
    pattern.equals(input) || pattern = "*"  true

    induction rule:
    "?"     dp[i][j] = dp[i-1][j-1]
    "*"     if the pattern character is "*" and there was a match on the previous step
            dp[i][j-1] = true   then, from that point to end, all is true
    "N"     dp[i][j] = dp[i-1][j-1] if element on that index also match

    Time: O(n^2)
    Space: O(n^2)
     */
    public boolean isMatch (String s, String p) {
        int sLen = s.length(), pLen = p.length();

        // base cases
        if (p.equals(s) || p.equals("*")) return true;
        if (p.isEmpty() || s.isEmpty()) return false;

        // init all matrix except [0][0] element as False
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;

        // DP compute
        for(int patternIndex = 1; patternIndex < pLen + 1; patternIndex++) {
            // the current character in the pattern is '*'
            if (p.charAt(patternIndex - 1) == '*') {
                int inputIndex = 1;
                // dp[p_idx - 1][s_idx - 1] is a string-pattern match
                // on the previous step, i.e. one character before.
                // Find the first idx in string with the previous math.
                while ((!dp[patternIndex - 1][inputIndex - 1]) && (inputIndex < sLen + 1)) {
                    inputIndex++;
                }
                // If (string) matches (pattern),
                // when (string) matches (pattern)* as well
                dp[patternIndex][inputIndex - 1] = dp[patternIndex - 1][inputIndex - 1];
                // If (string) matches (pattern),
                // when (string)(whatever_characters) matches (pattern)* as well
                while (inputIndex < sLen + 1) {
                    dp[patternIndex][inputIndex++] = true;
                }
            }
            // the current character in the pattern is '?'
            else if (p.charAt(patternIndex - 1) == '?') {
                for(int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    dp[patternIndex][sIdx] = dp[patternIndex - 1][sIdx - 1];
                }
            }
            // the current character in the pattern is not '*' or '?'
            else {
                for(int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    // Match is possible if there is a previous match
                    // and current characters are the same
                    dp[patternIndex][sIdx] = dp[patternIndex - 1][sIdx - 1] &&
                            (p.charAt(patternIndex - 1) == s.charAt(sIdx - 1));
                }
            }
        }
        return dp[pLen][sLen];
    }
}
