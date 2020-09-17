import java.util.ArrayList;
import java.util.List;

public class S5MMajorityNumberII {
    /**
     * if the current element is equal to one of the potential candidate, the count
     * for that candidate is increased while leaving the count of the other candidate
     * as it is
     * if the counter reaches zero, the candidate associated with that counter will
     * replaced with the next element if the next element is not equal to the
     * other candidate as well
     * Both counters are decremented only when the current element is different from
     * both candidates
     *
     * @param array
     * @return
     */
    public List<Integer> majorityElement (int[] array) {
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int n : array) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> result = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int n : array) {
            if (candidate1 != null && n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }
        int n = array.length;
        if (count1 > n/3) result.add(candidate1);
        if (count2 > n/3) result.add(candidate2);

        return result;
    }
}
