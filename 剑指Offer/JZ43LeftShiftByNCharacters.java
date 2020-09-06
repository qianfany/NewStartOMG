public class JZ43LeftShiftByNCharacters {
    /*
    AppleTree   n = 5
    reverse elppATree   0 - n-1
    reverse elppAeerT   n - end
    reverse TreeApple   0 - end

    Time: O(n)
    Space: O(1)
     */
    public String leftShiftString (String str, int n) {
        if (str.length() <= 1) return str;
        char[] array = str.toCharArray();
        n %= array.length;
        reverse(array, 0, n -1);
        reverse(array, n, array.length -1);
        reverse(array, 0, array.length -1);
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
