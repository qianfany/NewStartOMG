public class JZ2ReplaceSpace {
    /*
    Use a StringBuilder to accomplish this
    every time you meet " "
    add "%20"
    otherwise add the original character
    Time: O(n)
    Space: O(n)
     */
    public String replaceSpace1 (StringBuffer str) {
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

    public String replaceSpace2 (StringBuffer str) {
        return str.toString().replaceAll("", "%20");
    }


    /**
     * go backwards
     * first iteration find the number of space
     * enlarge the StringBuffer
     * change using setCharAt()
     *
     * @param str
     * @return String with all space replaced with ""
     */
    public String replaceSpace3 (StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int indexOld = str.length() - 1;
        int newLength = str.length() + spaceNum*2;
        int indexNew = newLength - 1;
        str.setLength(newLength);
        for (; indexOld >= 0 && indexOld < newLength; --indexOld) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
        }
        return str.toString();
    }
}
