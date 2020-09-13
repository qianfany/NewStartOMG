import java.util.*;

public class L140WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>(); // <Starting index, rst list>
        return dfs(s, 0, dict, memo);
    }

    private List<String> dfs(String s, int start, Set<String> dict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }

        String curr = s.substring(start);
        for (String word: dict) {
            if (curr.startsWith(word)) {
                List<String> sublist = dfs(s, start + word.length(), dict, memo);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        memo.put(start, res);
        return res;
    }
}
