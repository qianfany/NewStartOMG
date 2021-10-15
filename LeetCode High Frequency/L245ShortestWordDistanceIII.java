public class L245ShortestWordDistanceIII {

    public int shortestWordDistance (String[] wordsDict, String word1, String word2) {
        int idx = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (idx != -1 && (!wordsDict[i].equals(wordsDict[idx])
                        || word1.equals(word2))) {
                    minDistance = Math.min(minDistance, Math.abs(i - idx));
                }
                idx = i;
            }
        }
        return minDistance;
    }
}
