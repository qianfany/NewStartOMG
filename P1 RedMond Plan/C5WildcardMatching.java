public class C5WildcardMatching {
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

     */
    public boolean match (String input, String pattern) {
        int sLen = input.length(), pLen = pattern.length();

        // base cases
        if (pattern.equals(input) || pattern.equals("*")) return true;
        if (pattern.isEmpty() || input.isEmpty()) return false;

        // init all matrix except [0][0] element as False
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;

        // DP compute
        for(int patternIndex = 1; patternIndex < pLen + 1; patternIndex++) {
            // the current character in the pattern is '*'
            if (pattern.charAt(patternIndex - 1) == '*') {
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
            else if (pattern.charAt(patternIndex - 1) == '?') {
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
                            (pattern.charAt(patternIndex - 1) == input.charAt(sIdx - 1));
                }
            }
        }
        return dp[pLen][sLen];
    }
}
