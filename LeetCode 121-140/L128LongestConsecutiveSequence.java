import java.util.HashSet;
import java.util.Set;

public class L128LongestConsecutiveSequence {
    /*
      numbers are stored in a HashSet to allow O(1) lookups
      we only attempt to build sequences from numbers that are not already
      part of a longer sequence
      by first ensuring that the number that would immediately precede
      the sequence
      Time: O(N) while loop is only reached only the current is the first
      @param nums
      @return
     */
    public int longestConsecutive (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int currentSteak = 1;
                while (set.contains(current + 1)) {
                    current++;
                    currentSteak++;
                }
                longestStreak = Math.max(longestStreak, currentSteak);
            }
        }
        return longestStreak;
    }
}
