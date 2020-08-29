public class S2MReverseWordsInASentenceI {
    /*
    I love Google  -> Google love I
    step 1 swap the whole sentence -> legooG evol I
    step 2 swap every single word (two pointer) -> Google love I

     */

    public String reverseWords (String input) {
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] != ' ' && (j == 0 || array[j - 1] == ' ')) {
                i = j;
            }
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
}
