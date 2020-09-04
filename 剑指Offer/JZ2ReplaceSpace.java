public class JZ2ReplaceSpace {
    /*
    every time you meet " "
    add "%20"
    otherwise add the original character
    Time: O(n)
    Space: O(n)
     */
    public String replaceSpace (StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
