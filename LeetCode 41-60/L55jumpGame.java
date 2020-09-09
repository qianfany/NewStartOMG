public class L55jumpGame {
    /*
    Jump game:
    Solution 1. from left to right DP
    base case: M[0] = true
    Induction rule: M[i] represents whether I can reach index i form the start
    M[i] = true if there exists a j where j < i, M[j] == true && j + A[j] >= i
    return M[length - 1]
    Time = O(n^2)
    Space =  O(n)
     */
    public boolean canJump (int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canJump[j] && nums[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[nums.length - 1];
    }
}
