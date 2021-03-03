public class L3HuaweiCoding {
    /*
    Dynamic Programming

    [2, 3, -2, 4]
    [0, 6,  6   6]

    [-2, 0, -1]
    [0, 0, 0]

    OPT(i) represents the largest product at the array index i (include the index)

    base case: OPT(0) = 0
    Induction rule: OPT(i) = Max (nums[i] * OPT[i-1], nums[i])

    [2, 3, -2, 4]
    i   j

     */
    public int maxProduct (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmpMax * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

//
//    public int MaxProductI (int[] nums) {
//
//        int[] newArray = new int[nums.length];
//        newArray[0] = 0;
//        newArray[1] = nums[0] * nums[1];
//        for (int i = 2; i < nums.length; i++) {
//            newArray[i] = Math.max(newArray[i-1], newArray[i-1] * nums[i]);
//        }
//        return newArray[nums.length -1];
//    }

    public static void main (String[] args) {
        L3HuaweiCoding sol = new L3HuaweiCoding();
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        System.out.println(sol.maxProduct(nums1));
        System.out.println(sol.maxProduct(nums2));
    }
}
