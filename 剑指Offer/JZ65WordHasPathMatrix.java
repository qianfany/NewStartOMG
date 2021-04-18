public class JZ65WordHasPathMatrix {
    /*
    DFS

     */
    public boolean hasPath (char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        // dedup
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge (matrix, i, j, rows, cols,flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge (char[] matrix, int i, int j,
                           int rows, int cols, boolean[] flag, char[] str, int k) {
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k]
                || flag[index]) {
            return false;
        }
        // base case
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k+ 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        flag[index] = false;
        return false;
    }

    public static void main (String[] args) {
        JZ65WordHasPathMatrix sol = new JZ65WordHasPathMatrix();
        char[] matrix = {'a', 'b', 'c', 'd'};
        char[] str = {'a', 'b', 'c', 'd'};
        System.out.println(sol.hasPath(matrix, 2, 2, str));
    }
}
