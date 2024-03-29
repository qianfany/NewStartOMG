public class L132PalindromePartitionII {
    /**
    Dynamic Programming
    index = i, j
    dp[i] is substring[0, i] minimum numbers of cuts to make each partition palindrome
    Induction rule:
        Linear scan the while string to mark the string input.subtring (0, i)
        set dp[i] = max
        check palindrome from (j, i) if true -> dp[j] = min (dp[j - 1] + 1, dp[i])
        return dp[array.length - 1]
        time:   O(n^2)
        Space:  O(n)
     */
    public int minCut (String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] array = s.toCharArray();
        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 1; i < array.length; i++) {
            if (Palindrome(array, 0, i)) {
                dp[i] = 0;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (Palindrome(array, j, i)) {
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }
        return dp[array.length - 1];
    }
    private boolean Palindrome (char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
