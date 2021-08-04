import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L554BrickWall {

    public int leastBricks (List<List<Integer>> wall) {
        Map<Integer, Integer> count = new HashMap<>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }
        return wall.size() - maxCount;
    }
}
