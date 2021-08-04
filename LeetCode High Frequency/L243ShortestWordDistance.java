import java.util.List;

public class L243ShortestWordDistance {
    /*
    Always start with brute force solution

     */
    public int shortestDistance (String[] wordsDict, String word1, String word2) {
        int res = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                for (int j = 0; j < wordsDict.length; j++) {
                    if (wordsDict[j].equals(word2)) {
                        res = Math.min(res, Math.abs(i - j));
                    }
                }
            }
        }
        return res;
    }

    public int wordDistance (String word1, String word2, List<String> list) {
        int res = Integer.MAX_VALUE;
        if (list == null || list.size() == 0) {
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word1)) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).equals(word2)) {
                        res = Math.min(res, Math.abs(i - j));
                    }
                }
            }
        }
        return res;
    }
}
