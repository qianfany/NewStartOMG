import java.util.ArrayList;
import java.util.List;

public class L14LongestCommonPrefix {
    /*
    Iterative Reduction
    A1
    A2  ->   A12   2n
    A3       ->    A13    2n
    A4              ->    A14   2n
    Time: O(kn)
    Space: O(n)

    Binary Reduction
    A1
    A2  ->   A12 2n
    A3              -> A14 2n
    A4  ->   A34 2n
    A5                     -> A18  2n
    A6  ->   A56 2n
    A7              -> A58 2n
    A8  ->   A78 2n
    Time: O(kn)
    Space: O(kn)

    Heap k pointers
    minHeap stores all elements pointed by the k pointers
    max element = the maximum element in the min Heap
    case 1. min_heap.top() == max_element
        result.append(min_heap.top);
        i++; j++; k++
    case 2. otherwise
        find the smallest pointer in the min_heap
        min_heap.pop()
        min_heap.push<i, j+1>
        if <i, j+1> > max_element
            max_element = <i, j+1>
     time: O(kn * log k)
     Space: O(k)

     check only the prefix
     */
    public String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i =1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                // shorten the reference string
            }
        }
        return pre;
    }
}
