import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40CombinationSumII {
    /*
    each number in candidates may only be used once in the combination
     */

    public List<List<Integer>> combinationSum2 (int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main (String[] args) {
        L40CombinationSumII sol = new L40CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(sol.combinationSum2(candidates, target));
    }
}
