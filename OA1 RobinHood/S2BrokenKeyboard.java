import java.util.HashSet;
import java.util.Set;

public class S2BrokenKeyboard {
    public int brokenKeyboard (String text, String[] letters) {
        Set<Character> set = new HashSet<>();
        for (String s : letters) {
            set.add(s.charAt(0));
        }
        int res = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            char[] array = word.toCharArray();
            for (Character c : array) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    if (set.add(Character.toLowerCase(c))) {
                        res--;
                        break;
                    }
                }
            }
            res++;
        }
        return res;
    }


    public static void main (String[] args) {
        S2BrokenKeyboard sol = new S2BrokenKeyboard();
        String text = "Hello, this is CodeSignal!";
        String[] letter = {"e", "i", "h", "l", "o", "s"};
        System.out.println(sol.brokenKeyboard(text, letter));
    }



}
