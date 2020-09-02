public class C3ReverseWordsInASentenceII {

    public String reverseWords (String input) {
        String good = removeExtraSpace(input);
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

    public static void main (String[] args) {
        C3ReverseWordsInASentenceII sol = new C3ReverseWordsInASentenceII();
        String input = " I love      Google";
        System.out.println(sol.reverseWords(input));
    }
}
