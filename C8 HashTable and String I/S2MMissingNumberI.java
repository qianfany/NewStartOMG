import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class S2MMissingNumberI {
    /*
    Solution 1:
    HashSet
    insert all numbers in the input array to a hashSet
    for each number from 1 to n, find whether its in the hashtable
    Time: O(n) in average and O(n^2) in worst case
    Space: O(n)

    Solution 2:
    Bit operation: XOR
    a xor b = b xor a
    a xor (b xor c) = (a xor b) xor c
    0 xor a = a
    a xor a = 0
    Time: O(n)
    Space: O(1)
     */
    public int missingI (int[] array) {
        int n = array.length + 1;
        Set<Integer> set = new HashSet<>();
        for (int number : array) {
            set.add(number);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }

    public int missingII (int[] array) {
        int n = array.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }

}
