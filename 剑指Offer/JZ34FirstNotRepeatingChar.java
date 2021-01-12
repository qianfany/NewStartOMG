public class JZ34FirstNotRepeatingChar {
    /*
    use the ASCII to store the index,
    if charAt == 1 return
    Time:   O(N)
    Space:  O(256)
     */
    public int firstNonRepeatingChar (String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
