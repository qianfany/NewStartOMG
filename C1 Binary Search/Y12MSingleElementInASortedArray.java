public class Y12MSingleElementInASortedArray {
    /*
    set index as the single element location in the list

    behind index,  for locator m is even and m + 1 < index
        nums[m] == nums[m + 1]
    m + >= index
        nums[m] != nums[m + 1]
     */
    public int singleNonDuplicate (int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;
            }
            if (nums[m] == nums[m + 1]) {
                l =  m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
