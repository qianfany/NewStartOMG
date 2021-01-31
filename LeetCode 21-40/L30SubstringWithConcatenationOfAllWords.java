import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L30SubstringWithConcatenationOfAllWords {

    /*
      use hashmap to record the words and time
      check for every possible position
      compare both map to check if they are match

      Time: O(n * num * len)
      Space: O(words.size)

      @param s string of words
      @param words words that need to match
      @return list of indices that satisfy
     */
    public List<Integer> findSubstring (String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int num = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < sLen - num * wordLen + 1; i++) {
            String sub = s.substring(i, i + num * wordLen);
            if (isConcat(sub, counts, wordLen)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isConcat (String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i+= wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }


}
