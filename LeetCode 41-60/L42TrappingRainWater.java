public class L42TrappingRainWater {
    /*
                0   1   2   3   4
                2   1   3   2   4
                l               r
                    1       1
    Two pointers
    try to do it in one iteration
    Initialize left pointer to 0 and right pointer to size - 1
    while left < right
        if height(left) is smaller than height(right)
            update height left
            add result with the rain trap
            left++
        otherwise
            update height right
            add result with the rain trap
            right--
     Time: O(n)
     Space: O(1)
     */
    public int trap (int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length -1;
        int result = 0;
        int lMax = height[left];
        int rMax = height[right];
        while (left < right) {
            if (height[left] <= height[right]) {
                result += Math.max(0, lMax - height[left]);
                lMax = Math.max(lMax, height[left]);
                left++;
            }
            else {
                result += Math.max(0, rMax - height[right]);
                rMax = Math.max(rMax, height[right]);
                right--;
            }
        }
        return result;
    }
}
