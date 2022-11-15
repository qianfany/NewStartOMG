import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L1980FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        buildBinarySet(nums[0].length(), sb, set);
        Set<String> numsSet = new HashSet<>(Arrays.asList(nums));
        for (String s : set) {
            if (!numsSet.contains(s)) {
                return s;
            }
        }
        return "";
    }

    private void buildBinarySet(int length, StringBuilder sb, Set<String> set) {
        if (length == 0) {
            set.add(sb.toString());
            return;
        }
        sb.append('0');
        buildBinarySet(length - 1, sb, set);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('1');
        buildBinarySet(length - 1, sb, set);
        sb.deleteCharAt(sb.length() - 1);

    }

    public static void main(String[] args) {
        L1980FindUniqueBinaryString sol = new L1980FindUniqueBinaryString();
        String[] nums = {
                "01",
                "10"
        };
        System.out.println(sol.findDifferentBinaryString(nums));
    }
}
