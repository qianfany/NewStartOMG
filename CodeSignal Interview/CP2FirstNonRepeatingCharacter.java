public class CP2FirstNonRepeatingCharacter {
    /**
     * use ASCII to store the index
     * keep track of the index number
     * if == 1  return (char) index
     *
     * @param s
     * @return
     */
    public char firstNonRepeatingCharacter (String s) {
        if (s == null || s.length() == 0) {
            return '-';
        }
        char[] array = new char[256];
        for (char c : s.toCharArray()) {
            array[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return '-';
    }
}
