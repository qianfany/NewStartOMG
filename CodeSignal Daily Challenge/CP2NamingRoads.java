import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CP2NamingRoads {
    /*
    naming roads so that no two roads with neighboring names would have a common end

     */
    public boolean namingRoads (int[][] roads) {
        Arrays.sort(roads, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    return 0;
                }
                return o1[2] < o2[2] ? -1 : 1;
            }
        });
        for (int i = 1; i < roads.length; i++) {
            if (roads[i][0] == roads[i-1][0] || roads[i][0] == roads[i-1][1]
                    ||roads[i][1] == roads[i-1][0] || roads[i][1] == roads[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}
