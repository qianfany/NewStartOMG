public class S5ERemoveSpaces {
    /*
    j = 0 (fast) the letter being processed, all letters to the left side of j (not including j)
    are processed letters
    i = 0 (slow) all letters to the left-hand side of i (not including i) are all precessed letters
    that should be kept
    all letters [i - j - 1] are all area that we do not care (empty space)
    Time: O(n)
    Space: O(1)
     */
    public String removeSpaces (String input) {
        if (input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                continue;
            }
            array[end] = array[i];
            end++;
        }
        // post process, if the last index is empty
        if (end > 0 && array[end - 1] == ' ') {
            end--;
        }
        return new String(array, 0, end);
    }
}
