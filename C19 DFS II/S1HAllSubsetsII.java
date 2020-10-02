import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1HAllSubsetsII {
    /*
                            {}
                        /          \
                      {a}           {}                              for a
                   /      \       /      \
                {a, b}    {a}    {b}      {}                        for b
               /     \     |
            abb       ab   |                                        for b
           /   \      |    |
         abbb  abb    |    |                                        for b
         /      /     |    |
        abbbc abbc   abc   ac                                       for c

            add or not add
            level:      n
            branches:   2
            Time: O(2 ^ n)
            Space: O(n)
     skips all the rest of duplicated letters (b1, b2, b3)
     */
    public List<String> subSet (String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
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
        sb.deleteCharAt(sb.length() - 1);
        // skips all the rest of duplicated letters (b1, b2, b3)

        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        helper(array, sb, index + 1, result);
    }

    public static void main (String[] args) {
        S1HAllSubsetsII sol = new S1HAllSubsetsII();
        String set = "abbbc";
        System.out.print(sol.subSet(set));
    }
}
