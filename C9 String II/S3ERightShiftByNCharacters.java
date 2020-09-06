public class S3ERightShiftByNCharacters {
    /*
    AppleTree   n = 5
    reverse lppAeTree   0 - 8-n-1
    reverse lppAeerTe   8-n - 8
    reverse eTreeAppl   0 - 8
    Time: O(n)
    Space: O(1)
     */
    public String rightShift (String input, int n) {
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - n - 1);
        reverse(array, 0, array.length - 1);
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
