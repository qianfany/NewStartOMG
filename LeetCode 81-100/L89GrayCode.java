import java.util.ArrayList;
import java.util.List;

public class L89GrayCode {
    /*
                            {}
                        /          \
                      {a}           {}                              for a
                   /      \       /      \
                {a, b}    {a}    {b}      {}                        for b
               /   \     /   \   /   \    /  \
            abc    ab   ac    a  bc   b   c   {}                    for c

            add or not add
            level:      n
            branches:   2
            Time: O(2 ^ n)
            Space: O(n)

     skips all the rest of duplicated letters (b1, b2, b3)
     */
    public List<Integer> grayCode (int n) {
        if (n < 0)
            return new ArrayList<Integer>();
        if (n == 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            return list;
        }
        List<Integer> tmp = grayCode(n - 1);
        List<Integer> result = new ArrayList<Integer>(tmp);
        int addNumber = 1 << (n - 1);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            result.add(addNumber + tmp.get(i));
        }

        return result;
    }
}
