import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S5HAllPermutationsII {
    /*
    String permutation with duplicate letters
    maintain a hashSet

                        a b b b c
               /        |       |       |       \
          abbbc     babbc   (babbc)  (babbc)   cbbba
       / \ \ \
     abbbc   acbbb
     Time: O(n! * n)
     Space: O(n)
     */
    public List<String> permutations (String input) {
        List<String> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        char[] array = input.toCharArray();
        helper (array, 0, result);
        return result;
    }

    private void helper (char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap (array, i, index);
                helper (array, index + 1, result);
                swap (array, i, index);
            }
        }
    }
    private void swap (char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
