public class L4HuaweiCoding {
    /**
     ["flower", "flow", "flight"]
     output: "fl"

     ["dog", "racecar", "car"]
     ""
     Iterative Reduction:
     A1
     A2  -->   A12   2n
     A3         -->    A13     2n
     A4                 -->     A14   2n

     Time:    O(kn)
     Space:   O(n)

     Binary Reduction:
     A1
     A2   --> A12   2n
     A3                 A14  2n
     A4   --> A34   2n
     A5
     A6
     A7
     A8

     Time:    O(kn)
     Space:   O(kn)

     Heap k pointers
     minHeap
     case 1:
     case 2:

     */
    public String longestCommonPrefix (String[] strs) {
        // corner case
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0]; // first element
        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                // shorten the reference string
            }
        }
        return pre;
    }
    // test
    public static void main (String[] args) {
        L4HuaweiCoding sol = new L4HuaweiCoding();
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(sol.longestCommonPrefix(strs1));
        System.out.println(sol.longestCommonPrefix(strs2));
    }
}


