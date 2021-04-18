public class L13机器人的运动范围 {

    public int movingCount (int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return countingSteps(k, m, n, 0, 0, visited);
    }

    private int countingSteps (int k, int m, int n, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n
        || visited[i][j] || bitSum(i) + bitSum(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return countingSteps(k, m, n, i - 1, j, visited)
                + countingSteps(k, m, n, i, j - 1, visited)
                + countingSteps(k, m, n, i + 1, j, visited)
                + countingSteps(k, m, n, i, j + 1, visited) + 1;
    }

    private int bitSum (int t) {
        int count = 0;
        while (t != 0) {
            count += t % 10;
            t /= 10;
        }
        return count;
    }
}
