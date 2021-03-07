import java.util.Arrays;
import java.util.Comparator;

public class L452MinimumNumberofArrowstoBurstBallons {
    /*
    sort the array by its 2 nd from small to large
    case 1:  the following [i][0] <= the current end value
             continue
    case 2:  the following [i][0] > the current end value
             cnt ++
             end = points[i][1]
     */
    public int findMinArrowShots (int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
