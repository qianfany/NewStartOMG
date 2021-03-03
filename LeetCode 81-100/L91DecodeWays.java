import java.util.ArrayList;
import java.util.List;

public class L91DecodeWays {
    /*
                   2   3   2   6
                   /           \
               (2)326          (23)26
              /    \             /  \
       (2)(3)26  (2)(32)6(X)  (23)(2)6   (23)(26)(Y)
        /
             2 branches, left, add one, right, add number
              Time: O(2^n)
              Space: O(n)

      @param s input string
      @return  number of ways to encode the string
     */
    public int numDecodings (String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        helper (s, 0, sb, res);
        return res.size();
    }

    private void helper (String input, int index, StringBuilder sb, List<String> res) {
        if (index >= input.length()) {
            res.add(sb.toString());
            return;
        }
        int num = input.charAt(index) - '0';
        if (num > 0 && num <= 9) {
            sb.append((char) ('A' + num - 1));
            helper(input, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (index >= input.length() - 1) return;
        // invalid case with 1 element left to deal with add two
        num = num * 10 + input.charAt(index + 1) - '0';
        if (input.charAt(index) != '0' && num > 0 && num <= 26) {
            sb.append((char) ('A' + num - 1));
            helper(input, index + 2, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public int numDecodingsI (String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 1; i < n; i++) {
            int first = Integer.parseInt(s.substring(i, i+1));
            int second = Integer.parseInt(s.substring(i-1, i+1));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += i >=2 ? dp[i-2] : 1;
            }
        }
        return dp[n-1];
    }


    public static void main (String[] args) {
        L91DecodeWays sol = new L91DecodeWays();
        String s = "2326";
        System.out.println(sol.numDecodings(s));
    }
}
