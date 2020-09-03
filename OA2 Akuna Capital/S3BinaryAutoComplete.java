import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S3BinaryAutoComplete {

    public int[] autoComplete (String[] command, int n) {
        int[] result = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < command.length; i++) {
            String s = command[i];
            int length = s.length();
            int index = i;
            while (length >= 1) {
                if (map.containsKey(s.substring(0, length))) {
                    index = map.get(s.substring(0, length));
                    break;
                }
                map.put(s.substring(0, length), i + 1);
                length--;
            }
            while (length >= 1) {
                map.put(s.substring(0, length), i + 1);
                length--;
            }
            result[i] = index;

        }
        return result;
    }

    public static void main (String[] args) {
        S3BinaryAutoComplete sol = new S3BinaryAutoComplete();

        String[] command = {"000", "1110", "01", "001", "110", "11"};
        System.out.println(Arrays.toString(sol.autoComplete(command, 6)));
    }
}
