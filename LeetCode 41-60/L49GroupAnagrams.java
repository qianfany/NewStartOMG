import java.util.*;

public class L49GroupAnagrams {
    /*
    Maintain a map where each key K is a sorted string, and each value is the list
    of string from the initial input that when sorted, are equal to K

    Time: O(N * K * log K)      use K log K for sorting
    Space: O(N K)
     */
    public List<List<String>> groupAnagrams (String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList(map.values());
    }

    /**
     * instead of sorting, we can also build key string
     * Time:  O(N * K)
     * Space: O(N * K)
     */
    public List<List<String>> groupAnagramsI (String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
