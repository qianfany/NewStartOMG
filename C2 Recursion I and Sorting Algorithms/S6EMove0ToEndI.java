public class S6EMove0ToEndI {
    /*
    Initialization 2 walls 3 regions
    i = 0 -> :	all numbers to the left-hand side of i (not including i) are all “non-zero” ’s ,
                i is the current index to move
    [i, j]:		unknown area to explore
    j = <- size:	all numbers to the right hand side of j (not including j) are all “zeros”s
     */
    public int[] moveZero (int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] != 0) {
                left++;
            }
            else if (array[right] == 0) {
                right--;
            }
            else {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return array;
    }
    private void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
