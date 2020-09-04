import java.util.*;

public class S3BinaryAutoComplete {

    public List<Integer> autoComplete (List<String> command, int n) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < command.size(); i++) {
            String s = command.get(i);
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
            result.add(index);

        }
        return result;
    }

    public static void main (String[] args) {
        S3BinaryAutoComplete sol = new S3BinaryAutoComplete();

        String[] command = {"100110", "1001", "1001111"};
        List<String> list = new ArrayList<>();
        list.add("100110");
        list.add("1001");
        list.add("1001111");
        System.out.println(sol.autoComplete(list, 3));
    }
}
