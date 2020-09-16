import java.util.HashSet;
import java.util.Set;

public class CP4sudoku2 {

    public boolean sudoku2 (char[][] grid) {
        int n = grid.length;
        Set<String> set = new HashSet<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != '.' && !set.add(grid[row][col] + "in row" + row)) {
                    return false;
                }
                if (grid[row][col] != '.' && !set.add(grid[row][col] + "in col" + col)) {
                    return false;
                }
                if (grid[row][col] != '.' && !set.add(grid[row][col] + "in square" +
                        row / 3 + " " + col/3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
