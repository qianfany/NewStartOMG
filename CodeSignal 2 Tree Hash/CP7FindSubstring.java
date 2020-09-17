import java.util.HashMap;
import java.util.Map;

public class CP7FindSubstring {
    /**
     * Assumption: parts length is strictly <= 5
     * begin with longer numbers,
     * if substring matches the element in the parts
     * replace it with [sub]
     *
     * Time:
     * @param words
     * @param parts
     * @return
     */
    public String[] findSubstrings (String[] words, String[] parts) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : parts) {
            map.put(s, true);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();;
            for (int j = 5; j > 0; j--) {
                for (int k = 0; k <= len - j; k++) {
                    String sub = word.substring(k, k + j);
                    if (map.containsKey(sub)) {
                        words[i] = word.replaceFirst(sub, "[" + sub + "]");
                        j = -1;
                        break;
                    }
                }
            }
        }
        return words;
    }
}
