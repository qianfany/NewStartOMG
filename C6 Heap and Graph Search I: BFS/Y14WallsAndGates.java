import java.util.LinkedList;
import java.util.Queue;

public class Y14WallsAndGates {

    public int[][] wallsAndGates (int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return rooms;
        Queue<Cell> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Cell(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (cell.x >0 && rooms[cell.x - 1][cell.y] == Integer.MAX_VALUE){
                rooms[cell.x - 1][cell.y] = rooms[cell.x][cell.y] + 1;
                queue.offer(new Cell(cell.x - 1, cell.y));
            }
            if (cell.x < rooms.length - 1 && rooms[cell.x + 1][cell.y] == Integer.MAX_VALUE){
                rooms[cell.x + 1][cell.y] = rooms[cell.x][cell.y] + 1;
                queue.offer(new Cell(cell.x + 1, cell.y));
            }
            if (cell.y >0 && rooms[cell.x][cell.y - 1] == Integer.MAX_VALUE){
                rooms[cell.x][cell.y - 1] = rooms[cell.x][cell.y] + 1;
                queue.offer(new Cell(cell.x, cell.y - 1));
            }
            if (cell.y < rooms[0].length - 1 && rooms[cell.x][cell.y + 1] == Integer.MAX_VALUE){
                rooms[cell.x][cell.y + 1] = rooms[cell.x][cell.y] + 1;
                queue.offer(new Cell(cell.x, cell.y + 1));
            }
        }
        return rooms;
    }

    static class Cell {
        int x, y;
        Cell (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
