public class C1ValidPalindrome {
    /*
    determine if it is a palindrome consider only alpha numeric characters

    two pointer start, end
    check if they are valid and check if they are same
    case 1: not valid, i++ or j--
    case 2: not two characters are not same, return false
    case 3: same, i++ and j--
    Time: O(n)
    Space: O(1)
     */
    public boolean valid (String input) {
        if (input == null || input.length() == 0) {
            return true;
        }
        input = input.trim();
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(j);

            if (!isValid(c1)) {
                i++;
                continue;
            }
            if (!isValid(c2)) {
                j--;
                continue;
            }
            if (!isSame(c1, c2)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }


    private boolean isValid (char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    private boolean isSame (char c1, char c2) {
        if ((c1 >= '0' && c1 <= '9') || (c2 >= '0' && c2 <= '9')) {
            return c1 == c2;
        }
        else {
            return c1 == c2 || Math.abs(c1 - c2) == 'a' - 'A';
        }
    }
}
