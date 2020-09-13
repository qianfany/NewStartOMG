import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139WordBreak {
    /**
     *  Time: O(n^3)
     *  Space: O(n)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak (String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
