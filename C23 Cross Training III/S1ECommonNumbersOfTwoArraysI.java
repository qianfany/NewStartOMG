
import java.util.*;

public class S1ECommonNumbersOfTwoArraysI {
    /*
    Clarification / Assumptions:
        Ascending and descending
        Duplicate: input no duplicate, output duplicate
        data type: int
        Data size: fit into memory
    a = [1, 2, 5, 7]
         i->
    b = [2, 3, 5]
         j->
    case 1: i <= j, result.append(a[i]); i++
    case 2: otherwise, result.append(a[j]); j++

    use hashset
    1 for input of A
    2 for intersect

     */
    public List<Integer> common (int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int j = 0; j < b.length; j++) {
            if (set.contains(b[j])) {
                intersect.add(b[j]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer num : intersect) {
            result.add(num);
        }
        Collections.sort(result);
        return result;
    }

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

    /*
    Behavior question:
    1. Tell me about yourself
    2. About Quality Assurance. working as an SDET?
        - passion for QA work
        - experience in testing
    3. What's is your weakness?
        - know your weakness
    4.1 Can you describe one stressful situation at work and how you handled it
    4.2 if you missed a deadline, how would you explain to your manager?
        - how to handle stress
        - future plan to avoid
     */
}
