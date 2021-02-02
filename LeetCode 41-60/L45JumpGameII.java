public class L45JumpGameII {
    /*
    Dynamic Programming

    minJump record the min-number of jumps from 0 to each of the indices
    we do not need to jump from index 0
    base case: minJump[0] = 0
    Induction rule: minJump[i] represents the min-number of jumps from 0 to each of the indices
    M[i] = M[j] + 1     if minJump[j] != -1 && j + array[j] >= i    update min

                    2       3       1       1       4
                    0       1
                                    1
                                            2
                                                    2
    Time = O(n^2)
    Space = O(n)

     */
    public int jump (int[] nums) {
        int length = nums.length;
        int[] minJump = new int[length];

        minJump[0] = 0;
        for (int i = 1; i < length; i++) {
            minJump[i] = -1;
            // initialized as unreachable
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i && minJump[j] != -1) {
                    // can be reached
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                        // update the min
                    }
                }
            }
        }
        return minJump[length - 1];
    }

    // Time: O(n)
    // Space: O(1)
    /*
    by assuming that always reach the last index

        farthest    0   -> 2   ->    4
        jumps       0   -> 1   ->    2
        curEnd      0   -> 2   ->    4
                    2       3       1       1       4
                    0


     */
    public int jumpI (int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
