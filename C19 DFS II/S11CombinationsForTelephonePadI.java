import java.util.ArrayList;
import java.util.List;

public class S11CombinationsForTelephonePadI {
    /*
    Depth First Search
     level:
        number length
     branches:
        at most -> 4
                                231
                            /    |     \
                           a     b      c
                      /  |  \  /  |  \ /  |  \
                     ad  ae af bd be bf cd ce cf
     time: O(4 ^ n)
     Space: O(n)
     */
    public String[] combination (int number) {
        List<String> result = new ArrayList<>();
        String[] numToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        helper (Integer.toString(number).toCharArray(), numToChar, 0, sb, result);
        return result.toArray(new String[0]);
    }

    private void helper (char[] number, String[] numToChar, int level, StringBuilder sb, List<String> result) {
        if (level == number.length) {
            result.add(sb.toString());
            return;
        }
        char[] chars = numToChar[number[level] - '0'].toCharArray();
        // for the case of "0" and "1"
        if (chars.length == 0) {
            helper(number, numToChar, level + 1, sb, result);
        }
        else {
            for (int i = 0; i < chars.length; i++) {
                helper(number, numToChar, level + 1, sb.append(chars[i]), result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
