public class S6EMove0ToEndI {
    /*
    left right
    initialize left to 0  right = array.length - 1
    if left == 0 && right != 0
        swap (left, right)
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
