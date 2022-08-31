import java.util.HashSet;
import java.util.Set;

public class Q1CmmonElementsInSortedArrays {


    /*
Find all numbers that appear in both of two sorted arrays
2 arrays are all sorted in ascending order

Assumptions:
Both two arrays are not null

A = {1, 1, 2, 2, 3}
B = {1, 1, 2, 5, 6}
common numbers are {1, 2};

Using hashSet for deduplication
Time complexity: a.length + b.length
 */
    public void commonLite(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : b) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        System.out.println(result);
    }
    // Only result in hashSet
    public void commonLite2Pointer(int[] a, int[] b) {
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                set.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(set);
    }
    /*
    Follow-up
    In each of the two sorted arrays, there could be duplicate numbers
    please print all of them

    A = {1, 1, 2, 2, 3}
    B = {1, 1, 2, 5, 6}
    common numbers {1, 1, 2}

    two pointer method
     */

    public void commonII(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.println(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}
