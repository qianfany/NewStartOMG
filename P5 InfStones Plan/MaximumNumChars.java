import java.util.HashSet;
import java.util.Set;

public class MaximumNumChars {

    public String maximumNumChars (String str) {
        int n = str.length();
        int res = -1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j) && isUnique (str, i, j)) {
                    res = Math.max(res, Math.abs(j - i - 1));
                }
            }
        }
        return String.valueOf(res);
    }

    private boolean isUnique (String str, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int a = i + 1; a < j; a++) {
            if (!set.add(str.charAt(a))) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        MaximumNumChars sol = new MaximumNumChars();
        String str = "mmmerme";
        String str1 = "abccdefghi";
        System.out.println(sol.maximumNumChars(str));
        System.out.println(sol.maximumNumChars(str1));
    }
}
