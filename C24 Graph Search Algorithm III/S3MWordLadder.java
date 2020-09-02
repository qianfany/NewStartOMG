import java.util.*;

public class S3MWordLadder {
    /*
    Fewest Steps -> BFS 1
    Initial state: the starting word
    expand: first word in the queue
    Generate all words that can be converted from this expanded word in one step and that
    are in the dictionary
    Dedup: step[i] represents the number of steps needed to convert the start word to words[i]
    termination condition: the queue is empty or the ending word is generated
     */
    public int ladderLength (String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                char[] cur = queue.poll().toCharArray();
                for (int i=0; i < cur.length; i++) {
                    char tmp = cur[i];
                    for (char chr='a'; chr <= 'z'; chr++) {
                        cur[i] = chr;
                        String dest = new String(cur);
                        if (dict.contains(dest)) {
                            if (dest.equals(endWord)) return level+1;
                            queue.add(dest);
                            dict.remove(dest);
                        }
                    }
                    cur[i] = tmp;
                }
            }
            level++;
        }
        return 0;
    }
}
