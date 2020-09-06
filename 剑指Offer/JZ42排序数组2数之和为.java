import java.util.ArrayList;

public class JZ42排序数组2数之和为 {
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
    public ArrayList<Integer> twoSum (int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length -1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }
            else if (array[i] + array[j] > sum) {
                j--;
            }
            else {
                i++;
            }
        }
        return list;
    }
}
