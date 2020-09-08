public class L31NextPermutation {
    /*
    find a[i] <= a[i+1]
    find a[j] >= a[i]
    1   5   8   4   7   6   5   3   1
                i           j
    swap
    1   5   8   5   7   6   4   3   1
    reverse i + 1 -- end
    1   5   8   5   1   3   4   6   7

    Time: O(n)
    Space: O(1)
     */
    public void nextPermutation (int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);

        }
        reverse(nums, i + 1, nums.length - 1);
    }
    private void swap (int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    private void reverse (int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }
}
