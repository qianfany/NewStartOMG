public class S4MEditDistance {
    /*
    Edit Distance
    Dynamic Programming
    2 D matrix
                             s       g       h       j
    s2      |        0       1       2       3       4
    -------------------------------------------------
    s1   0  |        0       1       2        3      4
            |
    a    1  |        1       1       2        3      4
            |
    s    2  |        2       1       2        3      4
            |
    d    3  |        3       2       2        3      4
            |
    base case:
        M[0][0] = 0
        M[0][j] = j
        M[i][0] = i
    induction rule:
        M[i][j] represents the minimum number of actions to transform the first i letters
        of S1 to the first j letters of S2
        M[i][j] = M[i - 1][j - 1]                               if s1[i - 1] == s2[i - 1]
                = min (M[i-1][j-1], M[i-1][j], M[i][j-1] + 1)       otherwise

    Time: m * n
    Space: m * n7
     */
    public int editDistance (String one, String two) {
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                }
                else if (j == 0) {
                    distance[i][j] = i;
               }
                else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                }
                else {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1,
                            distance[i][j - 1] + 1), distance[i - 1][j - 1] + 1);
                }
            }
        }
        return distance[one.length()][two.length()];
    }
}
