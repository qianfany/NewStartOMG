public class L58LengthOfLastWord {
    /*
    Time: O(n)
    Space: O(1)
     */
    public int lengthOfLastWord (String s) {
        int lenIndex = s.length()-1;
        int len = 0;

        for (int i=lenIndex; i>=0 && s.charAt(i)==' '; i--)
            lenIndex--;
        // trim
        for (int i=lenIndex; i>=0 && s.charAt(i)!=' '; i--)
            len++;
        // get length
        return len;
    }
}
