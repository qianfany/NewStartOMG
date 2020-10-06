public class S5EMove0sToEndII {
    /*
    left:   all elements to the left side of left index are non-zeros
    right: fast pointer
    put all zeros to [left.....end)
    Time: O(N)      Space: O(1)
     */
    public int[] moveZero (int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                array[slow] = array[fast];
                slow++;
            }
        }
        for (int fast = slow; fast < array.length; fast++) {
            array[fast] = 0;
        }
        return array;
    }
}
