public class S10LongestCommonSubsequence {
    /*
                        a       b       c       d       e

                0       0       0       0       0       0

          c     0       0       0       1       0       0

          b     0       0       1       1       1       1

          a     0       1       1       1       1       1

          b     0       0       2       2       2       2

          d     0       0       2       2       3       3

          f     0       0       2       2       3       3

          e     0       0       2       2       3       4
     */
    public int longest (String source, String target) {
        int[][] longest = new int[source.length() + 1][target.length() + 1];
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                } else {
                    longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return longest[source.length()][target.length()];
    }
}
