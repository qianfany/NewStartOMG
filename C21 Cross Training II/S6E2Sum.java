import java.util.HashSet;
import java.util.Set;

public class S6E2Sum {
    /*
    return true or false or return index
    data size
    duplication (assume no duplication)
    sorted vs unsorted
    data type: int
    optimize for time or optimize for space
     */
    public boolean existSumI (int[] array, int target) {
        /*
        unsorted
        Maintain an hashSet to store values
        O(n) time in average, O(n) extra space
         */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(target - array[i])) {
                return true;
            }
            set.add(array[i]);
        }
        return false;
    }

    public boolean existSumII (int[] array, int target) {
        /*
        Sorted array use two pointer
        1 2 3 4 5 8 target 8
            i
                j
        case 1: a[i] + a[j] > target, j--
        case 2: a[i] + a[j] == target, return true
        case 3: a[i] + a[j] < target, i++
        O(n) time, O(1) space
         */
        int i = 0, j = array.length -1;
        while (i < j) {
            if (array[i] + array[j] == target) {
                return true;
            }
            else if (array[i] + array[j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }

    public boolean existSumIII (int[] array, int target) {
        /*
        unsorted
        optimize for space
         */
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        S6E2Sum sol = new S6E2Sum();
        int[] array = {3, 4, 0, -1, 2, 0, 5};
        System.out.println(sol.existSumIII(array, -2));
    }


}
