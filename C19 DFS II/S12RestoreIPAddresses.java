import java.util.ArrayList;
import java.util.List;

public class S12RestoreIPAddresses {
    /*
                                    25525511135
                   /                         |                     \
         2|5525511135                   25|525511135                255|525511135
       /    |     \                 /       |       \             /     |       \
 2|5|5...   2|55|...            25|5|2..   25|52|5..       255|5|2..    255|52|5... 255|525|1....

     check condition:
     not start "0"
     part < 256
     */
    public List<String> Restore (String ip) {
        List<String> res = new ArrayList<>();
        restoreHelper(ip, res, "", 0, 0);
        return res;
    }
    private void restoreHelper(String s, List<String> res, String restored, int pos, int sec) {
        // check whether left section is too lengthy to be valid
        if (s.length() - pos > 3 * (4 - sec)) return;
        if (sec == 4 && pos == s.length()) {
            res.add(restored);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()){
                return;
            }
            String part = s.substring(pos, pos + i);
            if (part.length() > 1 && part.startsWith("0") || i == 3 && Integer.valueOf(part) >= 256) {
                continue;
            }
            restoreHelper(s, res, sec == 0 ? part : restored + "." + part, pos + i, sec + 1);
        }
    }
}
