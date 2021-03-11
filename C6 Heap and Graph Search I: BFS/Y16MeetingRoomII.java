import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Y16MeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int rooms = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] gap = minHeap.poll();
            if (intervals[i][0] >= gap[1]) {
                gap[1] = intervals[i][1];
            } else {
                minHeap.offer(intervals[i]);
            }
            minHeap.offer(gap);
        }
        return minHeap.size();
    }

    public static void main (String[] args) {
        int[][] intervals = {
                {0, 4},
                {2, 6},
                {4, 8},
                {6, 10}
        };
        Y16MeetingRoomII sol = new Y16MeetingRoomII();
        System.out.println(sol.minMeetingRooms(intervals));
    }
}
