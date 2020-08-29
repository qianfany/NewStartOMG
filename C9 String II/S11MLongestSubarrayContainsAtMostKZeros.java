public class S11MLongestSubarrayContainsAtMostKZeros {

    /*
    s: the left border
    f: the right border
    count: the number of zeros within a[s..f]
    longest: the length of the longest valid sliding window

    initialize
    s = 0 f = 0
    for each step
    case 1: a[f+1] == 1  then f++, update longest
    case 2: a[f+1] == 0
        case 2.1: num_zero < k, then f++, count++, update longest
        case 2.2: num_zero == k, then s++, num_zero -= (a[s-1] == 0 ? 1 : 0)
     */
    public int longestConsecutiveOnes (int[] nums, int k) {
        int slow = 0;
        int fast = 0;
        int count = 0;
        int longest = 0;
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                fast++;
                longest = Math.max(longest, fast - slow);
            } else if (count < k) {
                count++;
                fast++;
                longest = Math.max(longest, fast - slow);
            } else if (nums[slow++] == 0) {
                count--;
            }
        }
        return longest;
    }
}
