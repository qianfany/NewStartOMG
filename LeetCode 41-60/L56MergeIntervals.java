import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class L56MergeIntervals {
    /*
    Use greedy algorithm
    sort the in descending order with respect to first number
    check if interval overlap with the previous
        update merge.getLast(1)
    otherwise
        merge.add

    Time: O(n log n)
    Space: O(n)
     */
    public int[][] merge (int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
