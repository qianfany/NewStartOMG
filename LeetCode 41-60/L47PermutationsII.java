import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L47PermutationsII {
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
    public List<List<Integer>> permuteUnique (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        helper (nums, 0, result);
        return result;
    }

    private void helper (int[] array, int index, List<List<Integer>> result) {
        if (index == array.length) {
            result.add(arrayToList(array));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, i, index);
                helper(array, index + 1, result);
                swap(array, i, index);
            }
        }
    }

    private void swap (int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private List<Integer> arrayToList (int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }
}
