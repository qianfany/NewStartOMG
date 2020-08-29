import java.util.ArrayList;
import java.util.List;

public class S4MAllPermutationsI {

    /*
        levels: each level represents one position
        branches: if we are on the i-th level, then we can try (n-i) branches
                                    abc
                  /                  |                 \
           abc swap(0,0)         bac swap(0, 1)       cba swap(0, 2)
       /             \           /            \        /             \
 abc swap(1,1)   acb swap(1,2) bac swap(1,1)
      |              |
 abc swap(2,2)   acb swap(2,2)
        Time:   O(n! * n)
        Space:  O(n)
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
        for (int i = index; i < array.length; i++) {
            swap (array, index, i);
            helper(array, index + 1, result);
            swap (array, index, i);
        }
    }

    private void swap (char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
