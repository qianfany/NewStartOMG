public class S9LongestCommonSubstring {
    /*
            a       b       c       d       e

      c     0       0       1       0       0

      d     0       0       0       2       0

      f     0       0       0       0       0

     */
    public String longestCommon (String source, String target) {
        char[] sa = source.toCharArray();
        char[] ta = target.toCharArray();

        int start = 0;
        int longest = 0;
        int[][] common = new int[sa.length][ta.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                if (sa[i] == ta[j]) {
                    if (i == 0 || j == 0) {
                        common[i][j] = 1;
                    } else {
                        common[i][j] = common[i - 1][j - 1] + 1;
                    }
                }
                if (common[i][j] > longest) {
                    longest = common[i][j];
                    start = i - longest + 1;
                }
            }
        }
        return source.substring(start, start + longest);
    }
}
