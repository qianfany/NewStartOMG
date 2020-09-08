import java.util.ArrayList;
import java.util.List;

public class L22GenerateParentheses {
    /*
                                empty
                            /           \
                           (              !)
                        /     \         /    \
                       ((     ()      !)(      !))
                     /   \   /   \    /  \     /  \
                   (((  (() ()(  !())

        add '(' |  add ')'
        add ')' has the condition that remaining of ")" is greater than "("
        levels : 2 * n
        branches: 2
        Time: O(2^ (2n))
        Space: O(2n)
     */
    public List<String> generateParenthesis (int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper (n, n, sb, 0, list);
        return list;
    }

    private void helper (int left, int right, StringBuilder sb, int index, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            helper (left - 1, right, sb, index + 1, list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            helper(left, right - 1, sb, index + 1, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
