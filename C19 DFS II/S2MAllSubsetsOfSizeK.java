import java.util.ArrayList;
import java.util.List;

public class S2MAllSubsetsOfSizeK {
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

        recursion tree has n levels, and it is a binary tree, (add or not add on each level)
        we can return as a base case when the size of the prefix-solution size == k

     */
    public List<String> subSetsOfSizeK (String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper (arraySet, k, sb, 0, result);
        return result;
    }

    private void helper (char[] arraySet, int k, StringBuilder sb, int index, List<String> result) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (index == arraySet.length) {
            return;
        }
        helper(arraySet, k, sb, index + 1, result);
        sb.append(arraySet[index]);
        helper(arraySet, k, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
