import java.util.Arrays;

public class L455AssignCookies {
    /*
    give at most one cookie
    time: O(N)
    space: O(1)
     */
    public int findContentChildren (int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;

        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
