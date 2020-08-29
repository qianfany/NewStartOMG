public class S4MStringAbbreviationMatching {

    /*
    Base case:
    text = "", pattern = ""; return true
    text = "", pattern != ""; return false
    text != "", pattern == ""; return false

    recursive rule
    if pattern[i] is a letter, then if pattern[i] matches text[i], recurse with
    match(text[i + 1], pattern[i + 1] )

    if pattern[i] is a digit, then read out all contiguous digits to form a number
    recurse to match(text[i + n], pattern[i + n] )

    Time:   O(n)
    Space:  O(n)
     */
    public boolean match (String input, String pattern) {
        return helper (input, pattern, 0, 0);
    }

    private boolean helper (String input, String pattern, int s, int t) {
        if (s == input.length() && t == pattern.length()) {
            return true;
        }
        if (s >= input.length() || t >= pattern.length()) {
            return false;
        }
        if (pattern.charAt(t) < '0' || pattern.charAt(t) > '9') {
            if (input.charAt(s) == pattern.charAt(t)) {
                return helper(input, pattern, s + 1, t + 1);
            }
            return false;
        }
        int count = 0;
        while (t < pattern.length() && pattern.charAt(t) >= '0'
                && pattern.charAt(t) <= '9') {
            count = count * 10 + (pattern.charAt(t) - '0');
            t++;
        }
        return helper(input, pattern, s + count, t);

    }

    public static void main (String[] args) {
        S4MStringAbbreviationMatching sol = new S4MStringAbbreviationMatching();
        System.out.println(sol.match("apple", "a3e"));
    }
}
