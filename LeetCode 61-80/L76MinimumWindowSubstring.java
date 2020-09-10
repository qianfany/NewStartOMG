import java.util.HashMap;
import java.util.Map;

public class L76MinimumWindowSubstring {

    public String minWindow (String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        // use hashMap to store the matching character and keep track of its number
        char[] array = t.toCharArray();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = t.length();
        // number of characters need to match
        int minLeft = 0;
        int minRight = 0;
        int min = s.length();
        boolean flag = false;

        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }
            // right window go right until find the [i, j] that contains t
            while (count == 0 && i <= j) {
                flag = true;
                int curLen = j + 1 - i;
                if (curLen <= min) {
                    minLeft = i;
                    minRight = j;
                    min = curLen;
                }
                char leftC = s.charAt(i);
                if (map.containsKey(leftC)) {
                    map.put(leftC, map.get(leftC) + 1);
                    if (map.get(leftC) >= 1) count++;
                }
                i++;
            }
            // update min window, left window shrink until

            j++;
        }
        return flag == true ? s.substring(minLeft, minRight + 1) : "";
    }
}
