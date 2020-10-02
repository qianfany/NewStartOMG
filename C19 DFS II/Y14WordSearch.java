public class Y14WordSearch {
    /**
     * Time:    O(M * N * 4 ^ L)
     * L is the length of the word
     * Space: O(L)
     * @param board
     * @param word
     * @return
     */
    public boolean isWord (char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search (char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0
                || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        if (search(board, word, i - 1, j, index + 1, visited)
                ||search(board, word, i +1 , j, index + 1, visited)
                ||search(board, word, i, j - 1, index + 1, visited)
                ||search(board, word, i, j + 1, index + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
