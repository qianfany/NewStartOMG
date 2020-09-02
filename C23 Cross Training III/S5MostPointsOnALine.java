import java.util.HashMap;
import java.util.Map;

public class S5MostPointsOnALine {
    /*
    Record the maximum number of points on the same line
    case 1. same point number
    case 2. same infinite slope
    case 3. same slope

     */
    public class Point {
         int x;
         int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int most (Point[] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Point seed = points[i];
            int same = 1; // record the points with same <x,y>
            int sameX = 0; // record hte points with same x, for infinite slope
            int most = 0; // max number of points on the same line
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point tmp = points[j];
                if (tmp.x == seed.x && tmp.y == seed.y) {
                    same++;
                } else if (tmp.x == seed.x) {
                    sameX++;
                } else {
                    double slope = (tmp.y - seed.y + 0.0) / (tmp.x - seed.x);
                    if (!cnt.containsKey(slope)) {
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, cnt.get(slope) + 1);
                    }
                    most = Math.max(most, cnt.get(slope));
                }
            }
            most = Math.max(most, sameX) + same;
            result = Math.max(result, most);
        }
        return result;
    }
}
