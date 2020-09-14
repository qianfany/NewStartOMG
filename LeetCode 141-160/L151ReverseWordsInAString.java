public class L151ReverseWordsInAString {
    /*
    Assumptions:
        1. the words are separated by one space character
        2. There are no leading or trailing spaces
        3. input is not null
    try to convert it to char array and solve the problem in-place

    I love Google  -> Google love I
    step 1 reverse the whole sentence -> legooG evol I
    step 2 reverse every single word (two pointer) -> Google love I
    time: O(n)
    Space: O(1)
     */
    public String reverseWords (String s) {
        String good = removeExtraSpace(s);
        char[] array = good.toCharArray();
        reverse(array, 0, array.length - 1);
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            // start index of a word
            if (array[j] != ' ' && (j == 0 || array[j - 1] == ' ')) {
                i = j;
            }
            // end index of a word
            if (array[j] != ' ' && (j == array.length - 1 || array[j + 1] == ' ')) {
                reverse(array, i, j);
            }
        }
        return new String(array);

    }
    private void reverse (char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    private String removeExtraSpace (String input) {
        return new String (input.trim().replaceAll("\\s{2,}", " "));
    }
}
