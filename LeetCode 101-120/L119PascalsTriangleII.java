import java.util.ArrayList;
import java.util.List;

public class L119PascalsTriangleII {
    public List<Integer> generate (int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int a = res.get(i - 1).get(j - 1);
                    int b = res.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            res.add(list);
        }
        return res.get(rowIndex);
    }
}
