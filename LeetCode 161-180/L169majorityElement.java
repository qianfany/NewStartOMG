public class L169majorityElement {
    /**
     * Boyer-Moore Voting Algorithm
     *      2   2   1   1   1   2   2
     *      count =
     *      candidate =
     * @param nums
     * @return
     * time: O(N)
     * Space: O(1)
     */
    public int majorityElement (int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
