import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L38字符串的排列 {

    public String[] permutation (String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        char[] array = s.toCharArray();
        List<String> result = new ArrayList<>();
        helper (array, 0, result);
        return result.toArray(new String[result.size()]);
    }

    private void helper (char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(String.valueOf(array));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, index, i);
                helper(array, index + 1, result);
                swap(array, index, i);
            }
        }
    }

    private void swap (char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
