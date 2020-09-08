public class L27RemoveElement {
    /*

    skip this element by incrementing fast
    as long as nums[fast] != val, nums[slow] = nums[fast]
    slow++, fast++
    repeat the process until fast reaches the end
    Time: O(n)
    Space: O(1)
     */
    public int removeElement (int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
