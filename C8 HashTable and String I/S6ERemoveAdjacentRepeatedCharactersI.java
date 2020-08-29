public class S6ERemoveAdjacentRepeatedCharactersI {
    /*
    left
    j = 1 (fast) the letter being processed. all letters to the left side of j (not including j)
    are processed letters
    i = 1 (slow) all letters to the left-hand side of i (not including i) are all processed letters
    that should be kept
    Time: O(n)
    Space: O(1)
     */
    public String deDup (String input) {
        if (input == null) {
            return null;
        }
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[fast - 1]) {
                array[slow] = array[fast];
                slow++;
            }
        }
        return new String(array, 0, slow);
    }
}
