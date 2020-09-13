import java.util.Arrays;

public class L134GasStation {
    /**
     * there exists solution when sum (gas) >= sum (cost)
     * Guaranteed unique solution
     *      [1, 2, 3, 4, 5]
     *      [3, 4, 5, 1, 2]
     *      Time: O(N^2)
     *      Space: O(1)
     *
     */
    public int canCompleteCircuit (int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            int remain = 0;
            int index = start;
            int length = 0;
            while (length < gas.length) {
                remain += gas[index];
                remain -= cost[index];
                if (remain < 0) {
                    break;
                }
                length++;
                index++;
                if (index == gas.length) {
                    index = 0;
                }
            }
            if (length == cost.length) {
                return index;
            }
        }
        return -1;
    }
}
