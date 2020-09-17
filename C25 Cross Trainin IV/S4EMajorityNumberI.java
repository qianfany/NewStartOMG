public class S4EMajorityNumberI {
    /**
     * if num of A is greater than half numbers of whole array
     * there exists
     * A        B
     * A        C
     * A        D
     *
     *
     * maintain a pair <E1 = candidate, value = counter>
     *     when a new element X comes in
     *          if counter == 0, just set <E1 = X, and counter == 1>
     *          else
     *              case 1: if X == candidate   counter++;
     *              case 2: else ,              counter--;
     * @param array
     * @return
     * Time: O(n)
     * Space: O(1)
     *
     */
    public int majority (int[] array) {
        int candidate = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                count++;
                candidate = array[i];
            } else if (candidate == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
