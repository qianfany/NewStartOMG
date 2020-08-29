public class S8MDetermineIfOneStringIsAnotherSubstring {
    /*
    for i = 0 to ??
        determine whether text[i...] == pattern
    Time: O(n ^ 2)
    Space: O(1)
     */
    public int strstr (String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (equals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }
    private boolean equals (String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    /*
    Solution 2:
    Rabin-Karp
    if we can hash the short string to a unique integer (via a hash function without
    collision), then we can just compare each substring of s1's hashed value and compare
    it with s2's hash value.
    1. remove the leftmost item from the polynomial function
    2. all the rest items of (bc's hashed value) * 26
    3. add new item d

    Time: O(m + n)
    m is the length of large String
    n is the length of small String
     */


}
