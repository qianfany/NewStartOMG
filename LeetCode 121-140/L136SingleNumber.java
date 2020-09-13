public class L136SingleNumber {
    /**
     *  use exclusive OR
     * @param nums
     * @return
     */
    public int singleNumber (int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}
