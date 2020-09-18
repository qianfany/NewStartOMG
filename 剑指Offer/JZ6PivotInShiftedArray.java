public class JZ6PivotInShiftedArray {
    /*
    use binary search
    case 1: array[mid] > array[high]
        3   4   5   6   0   1   2
                    m  ->
         low = mid
    case 2: array[mid] == array[high]
        1   0   1   1   1
                m
        1   1   1   0   1
                m
        in this case, hard to say, left++;
    case 3: array[mid] < array[high]
        2   2   3   4   5   6   6
               <-   m
        2   2   2   2
          high  = mid
     */
    public int minRotateArray (int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] < array[right]) {
                return array[left];
            }
            int mid = left + (right - left) / 2;
            if (array[mid] > array[left]) {
                left = mid;
            } else if (array[mid] < array[right]) {
                right = mid;
            }
            else {
                left++;
            }
        }
        return array[left];
    }

    public static void main (String[] args) {
        JZ6PivotInShiftedArray sol = new JZ6PivotInShiftedArray();
        int[] array1 = {3, 4, 5, 1, 2};
        int[] array2 = {3, 3, 3, 1, 3};
        int[] array3 = {3, 1, 3, 3, 3};
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(sol.minRotateArray(array1) + "    expected (1)");
        System.out.println(sol.minRotateArray(array2) + "    expected (1)");
        System.out.println(sol.minRotateArray(array3) + "    expected (1)");
        System.out.println(sol.minRotateArray(array4) + "    expected (0)");
    }
}
