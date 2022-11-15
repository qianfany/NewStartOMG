public class L523ContinuousSubarraySum {
    /*

     */
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = sum(nums, i, j);
                if (sum == 0 || sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private int sum(int[] nums, int i, int j) {
        int sum = 0;
        for (int index = i; index <= j; index++) {
            sum += nums[index];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 13;
        L523ContinuousSubarraySum sol = new L523ContinuousSubarraySum();
        System.out.println(sol.checkSubarraySum(nums, k));
    }
}
