public class L14剪绳子 {
    /*
    M[0] = 0    M[1] = 0

    M[2] = 1 * 1
    M[3]:
        case 1: max(1, M[1]) * 2 = 2
        case 2: max(2, M[2]) * 1 = 2
    M[4]:
        case 1: max(1, M[1]) * 3 = 3
        case 2: max(2, M[2]) * 2 = 4
        case 3: max(3, M[3]) * 1 = 3

    M[5]:
        case 1: max(1, M[1]) * 4 = 4
        case 2: max(2, M[2]) * 3 = 6
        case 3: max(3, M[3]) * 2 = 6
        case 4: max(4, M[4]) * 1 = 4
     */
    public int cuttingRope (int n) {
        int[] opt = new int[n + 1];
        opt[0] = 0;
        opt[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int max = Math.max(j, opt[j]) * (i - j);
                opt[i] = Math.max(max, opt[i]);
            }
        }
        return opt[n];
    }

    public int cuttingRopeGreedy (int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
