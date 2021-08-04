public class L1310XORQueriesOfASubarray {

    public int[] xorQueries (int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] res = new int[m];
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            res[i] = s[b + 1] ^ s[a];
        }
        return res;
    }
}
