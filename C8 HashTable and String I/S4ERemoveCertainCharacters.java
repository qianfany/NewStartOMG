import java.util.HashSet;
import java.util.Set;

public class S4ERemoveCertainCharacters {
    /*
    in place
    convert the immutable String to char[]
    get set of all distinct characters in t so that lookup

    slow: [0, slow) contains the valid result
    fast: [fast, array.length) is the area to explore
    exploring characters can only be put into valid area
    if its not in the set
    Time:   O(n)
    Space:  O()
    */
    public String remove (String input, String t) {
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(t);
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }
        return new String (array, 0, slow);
    }

    private Set<Character> buildSet (String t) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
}
