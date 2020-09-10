public class L80RemoveDuplicatesFromSortedArrayII {
    /*
    at most twice, in place

    1   1   1   1   2   2   3

    1   1   2   2   3

    two pointers, i and j
    i iterates of the array processing one element at a time and j keeps track of
    the next location in the array where we can overwrite an element
    count, track the count, the minimum = 1
    start at index 1 and process one element at a time in the array
    nums[i] == nums[i-1]    count++
    otherwise               count = 1

    update j, update nums[j] = nums[i] if count <= 2
    otherwise ignore
    Time: O(n)
    Space: O(1)
     */

    public int removeDuplicates (int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
