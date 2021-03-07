public class L392IsSubsequence {
    /*
    indexOf() method returns the position of the first occurrence
    of specified character in a string.

     */
    public boolean isSubsequence (String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

}
