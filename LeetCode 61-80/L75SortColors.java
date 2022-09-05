public class L75SortColors {
    /*
    two wall three region
    aaaaaaa bbbbb xxxxx ccccc
            i     j   k
    i = 0 -> : all letter to the left-hand side of i (not including i) are all "a"
    j = 0 -> : all letters in [i, j) are all b's, j is the current index
    [j, k] unexplored area (including j and k)
    k = n - 1 ->: all letters to the right-hand side of k (not including k) are all "c"s

    Time = O(n)
     */
    public void sortColors (int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;

        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, zero, one);
                zero++;
                one++;
            }
            else if (nums[one] == 1) {
                one++;
            }
            else {
                swap(nums, one, two);
                two--;
            }
        }
    }

    private void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
