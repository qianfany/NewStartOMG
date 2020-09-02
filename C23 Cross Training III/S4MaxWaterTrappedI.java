public class S4MaxWaterTrappedI {
    /*
                0   1   2   3   4
                2   1   3   2   4
                l               r
                    1       1
    Two pointers
    try to do it in one iteration
    Initialize left pointer to 0 and right pointer to size - 1
    while left < right
        if height(left) is smaller than height(right)
            update height left
            add result with the rain trap
            left++
        otherwise
            update height right
            add result with the rain trap
            right--
     */
    public int maxTrapped (int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0, right = array.length - 1;
        int result = 0;
        int lMax = array[left];
        int rMax = array[result];
        while (left < right) {
            if (array[left] <= array[right]) {
                result += Math.max(0, lMax - array[left]);
                lMax = Math.max(lMax, array[left]);
                left++;
            }
            else {
                result += Math.max(0, rMax - array[right]);
                rMax = Math.max(rMax, array[right]);
                right--;
            }
        }
        return result;
    }
}
