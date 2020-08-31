


import java.util.HashMap;
import java.util.Map;

public class S10M4Sum {
    /*
    4Sum = 2Sum + 2Sum      O(n^2)
    Key Point:
    1. if we can find two pairs <i1, j1> && <i2, j2> such that they satisfy the requirement
    a[i1] + a[j1] + a[i2] + a[j2] = target, and in the meantime, they follow the rule
    i1 < j1 < i2 < j2. Then, we can solve the problem and save searching time by avoiding
    checking whether <i1, j1, i2, j2> have duplicate values
    2. when store a pair sum into the hash_table, we need to guarantee that its right index j
    in <i, j> as small as possible
    Time: O(n^2)
    Space: O(n)
     */
    public class Pair {
        int left;
        int right;
        Pair (int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean exist (int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int j1 = 1; j1 < array.length; ++j1) {
            for (int i1 = 0; i1 < j1; ++i1) {
                int pairSum = array[j1] + array[i1];
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(i1, j1));
                }
            }
        }
        for (int i2 = 0; i2 < array.length; ++i2) {
            for (int j2 = i2 + 1; j2 < array.length; ++j2) {
                int pairSum = array[i2] + array[j2];
                // we need to guarantee there exists another pair with right index
                // smaller than the current pairs left index
                if (map.containsKey(target - pairSum) &&
                map.get(target - pairSum).right < i2) {
                    return true;
                }
            }
        }
        return false;
    }
}
