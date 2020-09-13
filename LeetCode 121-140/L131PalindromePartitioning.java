import java.util.ArrayList;
import java.util.List;

public class L131PalindromePartitioning {
    /**
     *                  abbbac
     *                /          \
     *               a           abbba
     *              /\ \             \
     *             b bb bbb         abbbac
     *            b  b   a
     *           b   a   c
     *          a    c
     *         c
     * @param s
     * @return
     * Time: O(2 ^ (n))
     */
    public List<List<String>> partition (String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper (s, 0, list, res);
        return res;
    }

    private void helper (String s, int index, List<String> list, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
        }
        else {
            for (int i = index; i < s.length(); i++) {
                if (Palindrome(s.toCharArray(), index, i)) {
                    list.add(s.substring(index, i + 1));
                    helper(s, i+ 1, list, res);
                    list.remove(list.size() - 1);
                    // backtracking
                }
            }
        }
    }

    private boolean Palindrome (char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
