public class S1MArrayHopperII {
    /*
    minJump record the min-number of jumps from 0 to each of the indices
    we do not need to jump for index 0
    base case: minJump[0] = 0
    Induction rule: minJump[i] represents the min-number of jumps from 0 to each of the indices
    M[i] = M[j] + 1     if minJump[j] != -1 && j + array[j] >= i    getmin
    Time = O(n^2)
    Space = O(n)

     */
    public int minJump (int[] array) {
        int length = array.length;
        int[] minJump = new int[length];

        minJump[0] = 0;
        for (int i = 1; i < length; i++) {
            minJump[i] = -1;
            // initialized as unreachable
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j] != -1) {
                    // can be reached
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[length - 1];
    }
}
