import java.util.HashSet;

public class S3MAllUniqueCharactersII {
    /*
    HashSet: all occurred characters during the linear scan

     */
    public boolean allUnique (String word) {
        HashSet<Character> occurredCharacters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (occurredCharacters.contains(word.charAt(i))) {
                return false;
            }
            occurredCharacters.add(word.charAt(i));
        }
        return true;
    }
    public static void main (String[] args) {
        S3MAllUniqueCharactersII sol = new S3MAllUniqueCharactersII();
        String word = "adcdrerd";
        System.out.println(sol.allUnique(word));
    }
}
