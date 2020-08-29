import java.util.HashSet;
import java.util.Set;

public class S9MLongestSubstringWithoutRepeatingCharacters {
    /*
       Assumptions: the input string is not null
       the distinct set contains all distinct characters the sliding window
       [slow, fast)
       if there is duplicate character, we need to move the slow pointer
       otherwise, we have a new sliding window of containing all distinct characters
     */
    public int longest (String input) {
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (slow < input.length() && fast < input.length()) {
            if (distinct.contains(input.charAt(fast))) {
                distinct.remove(input.charAt(slow));
                slow++;
            }
            else {
                distinct.add(input.charAt(fast));
                fast++;
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }
}
