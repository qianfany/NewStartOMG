import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CP5IsCryptSolution {
    /**
     * all characters will be in the solution
     * @param crypt
     * @param solution
     * @return
     */
    Map<Character, Integer> map;
    public boolean isCryptSolution (String[] crypt, char[][] solution) {
        map = new HashMap<>();
        for (char[] ele : solution) {
            map.put(ele[0], ele[1] - '0');
        }
        List<Integer> res = convert(crypt);
        String s1 = (String) Integer.toString(res.get(0));
        String s2 = (String) Integer.toString(res.get(1));
        if (s1.length() < crypt[0].length() || s2.length() < crypt[1].length()) {
            return false;
        }
        return res.get(0) + res.get(1) == res.get(2);
    }

    private List<Integer> convert (String[] crypt) {
        List<Integer> list = new ArrayList<>();
        for (String s : crypt) {
            int res = 0;
            for (char c : s.toCharArray()) {
                int num = map.get(c);
                res = res * 10 + num;
            }
            list.add(res);
        }
        return list;
    }

    public static void main (String[] args) {
        CP5IsCryptSolution sol = new CP5IsCryptSolution();
        String[] crypt = {"TEN", "TWO", "ONE"};
        char[][] solution = {
                {'O', '1'},
                {'T', '0'},
                {'W', '9'},
                {'E', '5'},
                {'N', '4'}
        };
        System.out.println(sol.isCryptSolution(crypt, solution));
    }
}
