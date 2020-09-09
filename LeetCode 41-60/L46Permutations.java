import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L46Permutations {
    /*
        levels: each level represents one position
        branches: if we are on the i-th level, then we can try (n-i) branches
                                    123
                  /                  |                 \
           123 swap(0,0)         213 swap(0, 1)       321 swap(0, 2)
       /             \           /            \        /             \
 123 swap(1,1)   132 swap(1,2) 213 swap(1,1)
      |              |
 123 swap(2,2)   132 swap(2,2)

        Time:   O(n! * n)
        Space:  O(n)
     */
    public List<List<Integer>> permute (int[] nums) {
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
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
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
