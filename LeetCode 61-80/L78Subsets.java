import java.util.ArrayList;
import java.util.List;

public class L78Subsets {
    /*
                            {}
                        /          \
                      {a}           {}                              for a
                   /      \       /      \
                {a, b}    {a}    {b}      {}                        for b
               /   \     /   \   /   \    /  \
            abc    ab   ac    a  bc   b   c   {}                    for c

            add or not add
            level:      n
            branches:   2
            Time: O(2 ^ n)
            Space: O(n)

     */
    public List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        helper (nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void helper (int[] nums, int start, List<Integer> cur, List<List<Integer>> res){
        if (start == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[start]);
        helper(nums, start + 1, cur, res);
        cur.remove(cur.size() -1);
        // 不加
        helper(nums, start + 1, cur, res);
    }

    public static void main(String[] args) {
        L78Subsets sol = new L78Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(sol.subsets(nums));
    }
}
