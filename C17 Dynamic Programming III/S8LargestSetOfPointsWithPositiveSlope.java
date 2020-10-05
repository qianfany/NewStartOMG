import java.util.Arrays;
import java.util.Comparator;

public class S8LargestSetOfPointsWithPositiveSlope {
    /*
    sort the points by x ascending and y descending
    similar to longest ascending subsequence
     */
    class Point {
        public int x;
        public int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int largest (Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;
            }
        });

        int[] dp = new int[points.length];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (points[j].y < points[i].y) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            max = Math.max(max, dp[i]);
        }
        return max == 1 ? 0 : max;
    }
}
