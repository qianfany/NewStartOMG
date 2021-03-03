public class L97interleavingString {
    /*
           #       d       b       b       c       a
      #    1       0       0       0       0       0

      a    1       0       0       0       0       0

      a    1       1       1       1       1       0

      b    0       1       1       0       0       0

      c    0       0       1       1       1       1

      c    0       0       0       1       0       1

            a    a   d   b   b   c   b   c   a   c

       dp[i][j] implies if it is possible to obtain a substring of length (i + j + 2)
       which is a prefix of s3 by some interleaving of prefixes s1 and s2 having length of
       (i+1) and (j+1)
       case 1: character just included either at ith index of s1 or at jth index of s2
       doesn't match the character at kth index of s3                  dp[i][j] = false
       otherwise:                                                      cp[i][j] = true
     */
    public boolean isInterLeave (String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }

        boolean[][] record = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0; i<=s1.length(); i++){
            if(s1.substring(0, i).equals(s3.substring(0, i))){
                record[i][0] = true;
            }
        }
        for(int i = 0; i<=s2.length(); i++){
            if(s2.substring(0, i).equals(s3.substring(0, i))){
                record[0][i] = true;
            }
        }
        for(int i = 1; i<=s1.length(); i++){
            for(int j = 1; j<=s2.length(); j++){
                if(record[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    record[i][j] = true;
                if(record[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    record[i][j] = true;
            }
        }
        return record[s1.length()][s2.length()];
    }
}
