public class L12矩阵中的路径 {

    public boolean exist (char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        char[] strs = word.toCharArray();
        boolean[][] flags = new boolean[board.length][board[0].length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(board, i, j, rows, cols, flags, strs, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean judge (char[][] matrix, int i, int j, int rows,
                           int cols, boolean[][] flags, char[] strs, int k) {
        if (i < 0 || j < 0 || i >= rows|| j >= cols
        || matrix[i][j] != strs[k] || flags[i][j]) {
            return false;
        }
        if (k == strs.length - 1) {
            return true;
        }
        flags[i][j] = true;
        if (judge(matrix, i - 1, j, rows, cols, flags, strs, k + 1)
        || judge(matrix, i + 1, j, rows, cols, flags, strs, k + 1)
        || judge(matrix, i, j - 1, rows, cols, flags, strs, k + 1)
        || judge(matrix, i, j + 1, rows, cols, flags, strs, k + 1)) {
            return true;
        }
        flags[i][j] = false;
        return false;
    }


    public static void main (String[] args) {
        L12矩阵中的路径 sol = new L12矩阵中的路径();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(sol.exist(board, word));
    }
}
