import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class S5MKthSmallestNumberInSortedMatrix2 {
    public int kthSmallest (int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value){
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        Set<Cell> visited = new HashSet<>();
        Cell first = new Cell(0, 0, matrix[0][0]);
        minHeap.offer(first);
        visited.add(first);

        for (int i = 0; i < k - 1; i++){
            Cell cell = minHeap.poll();
            if (cell.row + 1 < rows){
                Cell next = new Cell(cell.row + 1, cell.column, matrix[cell.row + 1][cell.column]);
                if (!visited.contains(next)){
                    minHeap.offer(next);
                    visited.add(next);
                }
            }
            if (cell.column + 1 < columns){
                Cell next = new Cell(cell.row, cell.column + 1, matrix[cell.row][cell.column + 1]);
                if (!visited.contains(next)){
                    minHeap.offer(next);
                    visited.add(next);
                }
            }
        }
        return minHeap.peek().value;

    }

    static class Cell {
        int row;
        int column;
        int value;
        Cell (int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return 31 * 31 * 31 * this.value + 31 * 31 * this.row + 31 * this.column;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (!(obj instanceof Cell)){
                return false;
            }
            Cell another = (Cell) obj;
            return this.value == another.value
                    && this.row == another.row
                    && this.column == another.column;
        }
    }
}
