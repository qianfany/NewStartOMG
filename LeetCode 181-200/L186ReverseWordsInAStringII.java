public class L186ReverseWordsInAStringII {


    public void reverseWords (char[] s) {
        reverse(s, 0, s.length - 1);
        int start = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ' && (i == 0 || s[i - 1] == ' ')) {
                start = i;
            }
            if (s[i] != ' '&& (i == s.length - 1 || s[i + 1] == ' ')) {
                reverse(s, start, i);
            }
        }
    }

    private void reverse (char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
