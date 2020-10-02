import java.util.*;

public class Y13PalindromePermutationII {

    public List<String> canPermutePalindromeII (String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        helper(array, 0, result);
        return result;
    }
    private void helper (char[] array, int index, List<String> list) {
        if (index == array.length) {
            if (Palindrome(array, 0, array.length - 1)) {
                list.add(new String(array));
            }
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, i, index);
                helper(array, index + 1, list);
                swap(array, i, index);
            }
        }
    }

    private boolean Palindrome (char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void swap (char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
