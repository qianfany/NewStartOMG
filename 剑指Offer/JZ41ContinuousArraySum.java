import java.util.ArrayList;
import java.util.List;

public class JZ41ContinuousArraySum {
    /*
    sliding window:
        Arithmetic sequence sum
        (N1 + Nn) * (num) /2
        current = (high + low) * (high - low + 1) /2
    case 1: current == sum
        put from low to high into the list
        high++
    case 2: current < sum
         high++
    case 3: current > sum
         low++
     */
    public List<List<Integer>> continuousSequence (int sum) {
        List<List<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        while (high > low) {
            int cur = (high + low) * (high - low + 1) /2;
            // arithmetic sequence sum
            if (cur == sum) {
                List<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                high++;
            } else if (cur < sum) {
                high++;
            } else {
                low++;
            }
        }
        return result;
    }
}
