public class S4MArrayHopperI {
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
    public boolean canJump (int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canJump[j] && array[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }

    public boolean canJumpII (int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
            }
            else {
                for (int j = array[i]; j >= 1; j--) {
                    if (canJump[j + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }
}
