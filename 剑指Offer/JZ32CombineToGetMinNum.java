import java.util.Arrays;
import java.util.Comparator;

public class JZ32CombineToGetMinNum {
    /*
    transfer the number into String, sort the string than combine them together
    override Comparator
    a = "3" b = "32"
    ab = "332"  ba = "323"
    ab > ba     means   a > b
    ab < ba     means   a < b
    Time: O(n log n)
    Space: O(n)
     */
    public String printMinNumber (int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int length = numbers.length;
        String[] str = new String[length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
