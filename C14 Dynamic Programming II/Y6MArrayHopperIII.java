public class Y6MArrayHopperIII {

    public int jump (int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0] == 0 ? -1 : 1;
        }

        int n = array.length;
        int[] M = new int[n];
        M[n - 1] = array[n - 1] == 0 ? -1 : 1;

        for (int i = n - 2; i >= 0; i--) {
            M[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (i + array[i] > n - 1) {
                    M[i] = 1;
                    break;
                }
                else if (i + array[i] >= j && M[j] != -1) {
                    if (M[i] == -1 || 1 + M[j] < M[i]) {
                        M[i] = 1 + M[j];
                    }
                }
            }
        }
        return M[0];
    }

    public static void main (String[] args) {
        Y6MArrayHopperIII sol = new Y6MArrayHopperIII();
        int[] array = {3, 2, 1, 1, 0};
        System.out.println(sol.jump(array));
    }
}
