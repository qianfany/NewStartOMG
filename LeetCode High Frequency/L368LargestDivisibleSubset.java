import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L368LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset (int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = allSubset(nums);
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (List<Integer> list : lists) {
            if (divisible(list) && list.size() > max) {
                res = list;
                max = list.size();
            }
        }
        return res;
    }

    private boolean divisible (List<Integer> nums) {
        for (int i = nums.size() - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (nums.get(i) % nums.get(j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<List<Integer>> allSubset (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res, 0, cur, nums);
        return res;
    }

    private void helper (List<List<Integer>> res, int index, List<Integer> cur, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        helper(res, index + 1, cur, nums);
        cur.remove(cur.size() - 1);
        helper(res, index + 1, cur, nums);
    }

    public static void main (String[] args) {
        L368LargestDivisibleSubset sol = new L368LargestDivisibleSubset();
        int[] nums = {3, 4, 16, 8};
//        List<Integer> nums1 = new ArrayList<>();
//        nums1.add(4);
//        nums1.add(8);
//        nums1.add(16);
//        System.out.println(sol.divisible(nums1));
        System.out.println(sol.largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubsetDP (int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 题目中说「没有重复元素」很重要
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }

}
