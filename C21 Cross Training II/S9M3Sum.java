import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S9M3Sum {
    /*
    Assumptions: array is not null, array.length >= 3
    Our goal is to find i < j < k, such that
    array[i] + array[j] + array[k] = target
    To make sure there is no duplicate triple
    we ignore all the duplicate possible i.
    first 2 will be selected as i
    Time: O(n^2)
    Space: O(1)
     */
    public List<List<Integer>> allTriples (int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int tmp = array[left] + array[right];
                if (tmp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (tmp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
