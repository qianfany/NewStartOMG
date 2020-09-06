import java.util.ArrayList;
import java.util.HashMap;

public class JZ54FirstNonRepeatingCharacterInSerial {
    /*
    maintain a hashMap
    key:  ch
    value: frequency
    maintain a list of the order of the entry sequence
     */
    HashMap<Character, Integer> map = new HashMap<>();
    ArrayList<Character> list = new ArrayList<>();
    public void insert (char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    public char firstAppearingOnce () {
        char c = '#';
        for (char key : list) {
            if (map.get(key) == 1) {
                c = key;
                break;
            }
        }
        return c;
    }
}
