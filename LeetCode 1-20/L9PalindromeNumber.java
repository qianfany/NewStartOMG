public class L9PalindromeNumber {
    /*
    reverse the integer by half
    check if they are the same or x == rev / 10
    time: O(n)
    Space: O(1)
     */
    public boolean isPalindrome (int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || x == rev / 10;
    }
}
