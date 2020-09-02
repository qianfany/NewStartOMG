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
}
