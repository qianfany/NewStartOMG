public class L6ZigZagConversion {
    /*
    for all numbers
    characters in row 0 are located at indexes k(2 * numRows  - 2)
    Character in row numRows - 1 are at indexes k(2 * numRow - 2) + numRows - 1
    Time: O(n) n = len(s)
    Space O(n)
     */
    public String convert (String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                // add first
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                    // add last
                }
            }
        }
        return ret.toString();
    }
}
