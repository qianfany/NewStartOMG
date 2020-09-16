import java.util.HashSet;
import java.util.Set;

public class L36ValidSudoku {
    /*
    Sudoku Properties
    Using HashSet

    Check same row
    check same column
    Check same block
    Time: O(n)
    Space: O(n)
     */
    public boolean isValidSudoku (char[][] board) {
        int n = board.length;
        Set<String> set = new HashSet<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] != '.' && !set.add(board[row][col] + "in row" + row)) {
                    return false;
                }
                if (board[row][col] != '.' && !set.add(board[row][col] + "in col" + col)) {
                    return false;
                }
                if (board[row][col] != '.' && !set.add(board[row][col] + "in square" +
                        row / 3 + " " + col/3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
