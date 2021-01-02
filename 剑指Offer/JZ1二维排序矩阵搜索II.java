public class JZ1二维排序矩阵搜索II {
    /*
    Starts from the bottom left,
    case 1: matrix[row][col] > target
        go up
    case 2: matrix[row][col] < target
        go right
    case 3: found the target
        return true
    search space reduction
    Time: O(n + m)
    Space: O(1)
     */
    public boolean Find (int target, int [][] array) {
        int row = array.length - 1;
        int col = 0;

        while (row >= 0 && col < array[0].length) {
            if (array[row][col] > target) {
                row--;
            }
            else if (array[row][col] < target) {
                col++;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        JZ1二维排序矩阵搜索II sol = new JZ1二维排序矩阵搜索II();
        int target = 7;
        int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        System.out.println(sol.Find(target, array));
    }
}
