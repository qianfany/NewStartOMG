import java.util.Arrays;
import java.util.Comparator;

public class L179LargestNumber {

    public String largestNumbers (int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        String[] array = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            array[i] = String.valueOf(num[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(array, comp);
        if (array[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String largestNumber (int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(array, comp);
        if (array[0].charAt(0) == '0') {
            return "0";
        }
        return String.join("", array);
    }
}
