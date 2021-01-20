import java.util.HashSet;
import java.util.Set;

public class L3LongestSubstringWithoutRepeatingCharacters {
    /*
       Assumptions: the input string is not null
       Maintain a HashSet
       the distinct set contains all distinct characters the sliding window
       [slow, fast)
       if there is duplicate character, we need to move the slow pointer
       otherwise, we have a new sliding window of containing all distinct characters    update longest
       Time:    O(2n)
       Space:   O(n)
     */
    public int length (String s) {
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (slow < s.length() && fast < s.length()) {
            if (distinct.contains(s.charAt(fast))) {
                distinct.remove(s.charAt(slow));
                slow++;
            }
            else {
                distinct.add(s.charAt(fast));
                fast++;
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }
}
