import java.util.Arrays;

public class L21调整数组顺序使奇数位于偶数前面 {
    /*
    swap
    two pointer
    1       2       3       6       5       7       8       9
    i                                                       j

    if nums[i] == odd
            i++
    if nums[i] == even
            swap
            j--
     */
    public int[] exchange (int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if ((nums[i] & 1) == 0) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        return nums;
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main (String[] args) {
        int[] nums = {1, 2, 3, 6, 5, 7, 8, 9};
        L21调整数组顺序使奇数位于偶数前面 sol = new L21调整数组顺序使奇数位于偶数前面();
        System.out.println(Arrays.toString(sol.exchange(nums)));
    }
}
