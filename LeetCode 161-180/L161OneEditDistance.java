public class L161OneEditDistance {
    /**
     *  s is always shorter than t
     *  1.  replace
     *          a B c
     *          a D c
     *  2.  delete
     *          a  b c
     *          a D b c
     *  if not equal
     *      s.substring(i + 1).equals (t.substring(i + 1))
     *  otherwise
     *      s.substring(i).equals (t.subtring(i + 1))
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance (String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n2 < n1) {
            return isOneEditDistance(t, s);
        }
        boolean sameDist = (n1 == n2);
        for (int i = 0; i < n1; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sameDist) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1 ;
    }
}
