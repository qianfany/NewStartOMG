import java.util.ArrayList;
import java.util.List;

public class L57InsertInterval {
    /*
    Greedy Algorithm:
    --  ----      --      ---       ------------
            ---------------                     merge
    --  ---------------------       ------------

    Add to the output of all the intervals starting (before) newInterval
    Add to the output newInterval. Merge it with the (last) added interval
    Add the next intervals one by one merge with the last added interval
    if the current interval starts before the last added interval
     */
    public int[][] insert (int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for(int[] i : intervals){
            if(newInterval == null || i[1] < newInterval[0]){
                result.add(i);
            }else if(i[0] > newInterval[1]){
                // be carefult the sequence here
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            }else{
                newInterval[0] = Math.min(newInterval[0], i[0]);//get min
                newInterval[1] = Math.max(newInterval[1], i[1]);//get max
            }
        }
        // post process
        if(newInterval != null){
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
