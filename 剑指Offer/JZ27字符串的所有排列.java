import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JZ27字符串的所有排列 {
    /*
    String permutation with duplicate letters
    maintain a hashSet to deduplication

                        a b b b c
               /        |       |       |       \
          abbbc     babbc   (babbc)  (babbc)   cbbba
       / \ \ \
     abbbc   acbbb
     Time: O(n! * n)
     Space: O(n)
     */

    public ArrayList<String> permutation (String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] array = str.toCharArray();
        helper (array, 0, result);
        return result;
    }

    private void helper (char[] array, int index, ArrayList<String> result) {
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
