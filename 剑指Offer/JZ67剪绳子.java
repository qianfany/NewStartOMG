public class JZ67剪绳子 {
    /*
        M[0] = 0    M[1] = 0

        M[2] = 1 * 1 = 1
        M[3]:
            case 1: max(1, M[1]) * 2 = 2
            case 2: max(2, M[2]) * 1 = 2
        M[4]:
            case 1: max(1. M[1]) * 3 = 3
            case 2: max(2, M[2]) * 2 = 2
            case 3: max(3, M[3]) * 1 = 3
        M[5]:
            case 1: max(1, M[1]) * 4 = 4
            case 2: max(2, M[2]) * 3 = 6
            case 3: max(3, M[3]) * 2 = 6
            case 4: max(4, M[4]) * 1 = 4
        time: O(n^2)
        Space: O(n)
     */
    public int cutRope (int target) {
        int[] M = new int[target + 1];
        M[0] = 0; M[1] = 0;
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                int max = Math.max(j, M[j]) * (i - j);
                M[i] = Math.max(max, M[i]);
            }
        }
        return M[target];
    }
}
