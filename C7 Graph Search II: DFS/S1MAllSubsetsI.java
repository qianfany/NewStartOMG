import java.util.ArrayList;
import java.util.List;

public class S1MAllSubsetsI {
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

    public List<String> subSets (String set) {
        List<String> result = new ArrayList<>();
        if (set == null) return result;
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper (array, sb, 0, result);
        return result;
    }
    private void helper (char[] array, StringBuilder sb, int index, List<String> result) {
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }
        sb.append(array[index]);
        helper(array, sb, index + 1, result);
        sb.deleteCharAt(sb.length() -1);
        helper(array, sb, index + 1, result);
    }
    public static void main (String[] args) {
        S1MAllSubsetsI sol = new S1MAllSubsetsI();
        String set = "abc";
        System.out.println(sol.subSets(set));
    }
}
