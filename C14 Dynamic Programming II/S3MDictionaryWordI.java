import java.util.HashSet;
import java.util.Set;

public class S3MDictionaryWordI {
    /*
    bobcatrob                   dictionary: "bob" "cat" "rob"
    input is not null or empty
    canBreak[i] represents index(i-1) in input,
    [b o b c a t r o b]
  [1 0 0 1 0 0 1 0 0 1]

     */
    public boolean canBreak (String input, String[] dict) {
        Set<String> dictSet = toSet(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;

        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(input.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }


    private Set<String> toSet (String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }

    public static void main (String[] args) {
        String s = "bobc";
        System.out.println(s.substring(0, 3));
    }
}
