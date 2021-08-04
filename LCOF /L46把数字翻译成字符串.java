import java.util.ArrayList;
import java.util.List;

public class L46把数字翻译成字符串 {
    /*
                                12258
                           /                  \
                         1                    12
                    /            \              /        \
                 1 2             1 22      (12) 2       (12) (25)
               /     \           /    \    /      \     /      \
         1 2 2    1 2 (25)   1 22 5      (12) 2 5

       2 branches, left, add one, right, add number
       Time:    O(2^n)
       Space:   O(n)
     */

    public int translateNum (int num) {
        if (num == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        return list.size();
    }

    private void dfs (int num, int index, List<Integer> list) {
        return;
    }
}
