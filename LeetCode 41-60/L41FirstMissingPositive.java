public class L41FirstMissingPositive {
    /*
    run in O(n) time and O(1) extra space
    once all numbers are made positive, if any number is found in range [1, N]
    then attach -ve sign to the corresponding index.
    the missing integer the solution space is range of integers [1....n]

    1- Ignore all numbers <=0 and >n since they are outside the range of possible answers
    (which we proved was [1..n]). We do this by replacing them with the value n+1.
    2- For all other integers < n+1, mark their bucket (cell) to indicate the integer exists.
    3- Find the first cell not marked, that is the first missing integer.
    If you did not find an unmarked cell, there was no missing integer, so return n+1.

    Time:   O(n)
    SPace:  O(1)
     */
    public int firstMissingPositive (int[] nums) {
        int n = nums.length;

        // mark numbers (num < 0) and (nums > 0) with special marker (n+1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // mark each cell appearing in the array, by converting to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }
        // find the first cell which isn't negative
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        // no positive numbers found, return n + 1
        return n + 1;
    }

    public static void main (String[] args) {
        L41FirstMissingPositive sol = new L41FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        System.out.println(sol.firstMissingPositive(nums));
    }
}
