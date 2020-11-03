public class Y1AllUniqueCharactersI {
    /* 1. brute force approach, compare     O(n^2) times
       2. using sorting,                    O(n log n) times
       3. Bit Operation,                    O(n) times

       instead of maintaining a boolean array, we maintain an integer
       value called checker (32 bits). As we iterate over the string,
       we find the int value of the character with respect to 'a' with
       the statement str.charAt(i) - 'a'
       then the bit at that int value is set to 1 with statement
       1 << bitAtIndex, now if this bit is already set in the checker,
       the bit AND operation would make checker > 0. Return false in
       this case.
       Else update the checker to make the bit 1 at that index with
       checker = checker | (1 << bitAtIndex)

    */
    public boolean allUnique (String word) {
        int checker = 0;

        for (int i = 0; i < word.length(); i++) {
            int bitAtIndex = word.charAt(i) - 'a';

            if ((checker & (1 << bitAtIndex)) > 0) {
                return false;
            }
            checker = checker | (1 << bitAtIndex);
        }
        return true;
    }

    public static void main (String[] args) {
        Y1AllUniqueCharactersI sol = new Y1AllUniqueCharactersI();
        String word = "yangqianfan";
        System.out.println(sol.allUnique(word));
    }
}
