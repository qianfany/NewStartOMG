import java.util.ArrayList;
import java.util.List;

public class S1MSpiralOrderTraverseI {
    /*
    Assumption: square matrix

    print the outer layer first
    use recursion, define sub-problem as the (size - 2) matrix
    offset is initially set to 0
    print outer layer upper row         0
    print outer layer right column      size - 1
    print outer layer bottom row        size - 1
    print outer layer left column       0
    recursively do with (size - 2)
     */
    public List<Integer> spiral (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        helper (matrix, 0, matrix.length, list);
        return list;
    }

    private void helper (int[][] matrix, int offset, int size, List<Integer> list) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            list.add(matrix[offset][offset]);
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            list.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            list.add(matrix[offset + i][offset + size - 1]);
        }
        for (int i = size - 1; i >= 1; i--) {
            list.add(matrix[offset + size - 1][offset + i]);
        }
        for (int i = size - 1; i >= 1; i--) {
            list.add(matrix[offset + i][offset]);
        }
        helper(matrix, offset + 1, size - 2, list);

    }
}
