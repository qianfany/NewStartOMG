public class S1EReverseString {
    /*
    Iterative solution:
    using swap from two side
    Time: O(n)
    Space: O(1)
     */
    public String reverse (String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
        return new String(array);
    }

    private void swap (char[] array, int a, int b) {
        char tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    /*
    Recursive reverse:
    Time: O(n)
    Space: O(n)
    base case:  left >= right
    swap(left, right)
    sub problem:    reverse (array, left + 1, right - 1)

     */
    public String reverseI (String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        reverseHelper (array, 0, array.length - 1);
        return new String (array);
    }

    private void reverseHelper (char[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, right);
        reverseHelper(array, left + 1, right - 1);
    }
}
