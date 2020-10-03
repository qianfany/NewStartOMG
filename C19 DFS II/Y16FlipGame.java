import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Y16FlipGame {

    public List<String> generatePossibleNextMoves (String input) {
        List<String> ans = new ArrayList<>();
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == '+' && array[i + 1] == '+') {
                array[i] = '-';
                array[i + 1] = '-';
                ans.add(new String(array));
                array[i] = '+';
                array[i + 1] = '+';
            }
        }
        return ans;
    }

    public boolean canWin (String input) {
        if (input == null || input.length() < 2) {
            return false;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.startsWith("++", i)) {
                String t = input.substring(0, i) + "--" + input.substring(i + 2);

                if (!canWin(t)) {
                    return true;
                }
            }
        }

        return false;
    }
}
