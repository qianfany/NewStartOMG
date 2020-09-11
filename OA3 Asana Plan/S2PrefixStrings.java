import java.util.HashSet;
import java.util.Set;

public class S2PrefixStrings {

    public boolean prefixStrings (String[] a, String[] b) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            sb.append(s);
            set.add(sb.toString());
        }

        for (String t : b) {
            if (set.add(t)) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        S2PrefixStrings sol = new S2PrefixStrings();
        String[] a = {"one", "two", "three"};
        String[] b = {"onetwo", "one"};
        System.out.println(sol.prefixStrings(a, b));
    }
}
