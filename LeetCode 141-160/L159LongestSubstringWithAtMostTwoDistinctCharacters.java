import java.util.HashMap;
import java.util.Map;

public class L159LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthTwoDistinct (String s) {
        if (s == null) return 0;

        int left = 0; // slow pointer
        int right = 0; // fast pointer
        int max = 0;

        // use a map to track the char and its count
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (map.size() < 2 || map.containsKey(ch)) {
                // less than 2 distinct chars or the char is in the map already
                // put it to the map and update the count
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // update the max
                right++;
                max = Math.max(max, right - left);
            } else {
                // we keep removing the old chars from the map
                // till we only have one distinct char
                while (map.size() == 2) {
                    ch = s.charAt(left);
                    left++;
                    if (map.get(ch) > 1)
                        map.put(ch, map.get(ch) - 1);
                    else
                        map.remove(ch);
                }
            }
        }

        return max;
    }
}
