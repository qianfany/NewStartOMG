public class Y9RemoveAdjacentRepeatedCharactersII {
    /*
    aaaabbbc -->  aabbc
    leaving only two characters for each group of such characters
    a   a   a   a   b   b   b   c

    High level idea: use a slow = 1, fast = 2 index to traverse the array
    changing condition: array[slow - 1] != array[fast]
        array[slow+1] = array[fast]; slow++; fast++;
    else
        fast++

     */
    public String deDup (String input) {
        if (input.length() <= 2) {
            return input;
        }
        int slow = 1, fast = 2;
        char[] array = input.toCharArray();
        while (fast < input.length()) {
            if (array[slow - 1] != array[fast]) {
                array[slow + 1] = array[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return new String(array, 0, slow + 1);
    }

    public static void main (String[] args) {
        Y9RemoveAdjacentRepeatedCharactersII sol = new Y9RemoveAdjacentRepeatedCharactersII();
        String input = "aaaabbcccddeeeff";
        System.out.println(sol.deDup(input));
    }
}
