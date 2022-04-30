import java.util.*;

public class L211DesignAddSearchWordsDataStructure {
    Map<Integer, List<String>> map = new HashMap<>();
    public L211DesignAddSearchWordsDataStructure () {

    }

    public void addWord (String word) {
        int length = word.length();
        if (!map.containsKey(length)) {
            map.put(length, new ArrayList<>(Arrays.asList(word)));
        } else {
            map.get(length).add(word);
        }
    }

    public boolean search (String word) {
        int length = word.length();
        if (!map.containsKey(length)) {
            return false;
        }
        List<String> list = map.get(length);
        for (String s : list) {
            if (isSame(word, s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame (String word, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.'
                    && word.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
