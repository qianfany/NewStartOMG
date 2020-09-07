public class L11ContainerWithMostWater {
    /*
                0   1   2   3   4
                2   1   3   2   4
                l               r
                    1       1

     Initialize left pointer to 0 and right pointer to size - 1
     while left < right
            if height(left) is smaller than height
                left++
                update area
            otherwise
                right--
                update area
     */
    public int maxArea (int[] height) {
        int maxArea =0 ;
        int l = 0;
        int r = height.length -1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r-l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
