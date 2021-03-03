public class L680ValidPalindromeII {

    public boolean validPalindrome (String s) {
        int n = s.length();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (helper(s, l + 1, r)) {
                    return true;
                }
                return helper(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean helper (String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
