public class L125ValidPalindrome {

    public boolean isPalindrome (String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.trim();
        int i = 0, j = s.length() - 1;
        while ( i < j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!isValid(c1)){
                i++;
                continue;
            }
            if (!isValid(c2)){
                j--;
                continue;
            }
            if (!isSame(c1, c2)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;

    }


    private boolean isValid (char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
            return true;
        } return false;
    }

    private boolean isSame (char c1, char c2) {
        if ((c1 >= '0' && c1 <= '9') || (c2 >= '0' && c2 <= '9')) {
            return c1 == c2;
        }
        else {
            return c1 == c2 || Math.abs(c1 - c2) == 'a' - 'A';
        }
    }
}
