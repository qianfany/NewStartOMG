public class CP3RotateImage {
    /**
     *
     * @param a
     * @return
     */
    public int[][] rotateImage (int[][] a) {
        int n = a.length;
        if (n <= 1) {
            return a;
        }
        int round = n / 2;
        for (int level = 0; level < round; level++) {
            int left = level;
            int right = n - 2 - level;
            for (int i = left; i <= right; i++) {
                int tmp = a[left][i];
                a[left][i] = a[n - 1 - i][left];
                a[n - 1 - i][left] = a[n - 1 - left][n - 1 - i];
                a[n - 1 - left][n - 1 - i] = a[i][n - 1 - left];
                a[i][n - 1 - left] = tmp;
            }
        }
        return a;
    }
}
