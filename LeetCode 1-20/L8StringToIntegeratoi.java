public class L8StringToIntegeratoi {
    /*
    1. null, "" -> 0
    2. "    123" -> 123
    3. "+123" -> 123, "-123" -> -123
    4. "123 1" -> 123, "123a1" -> 123, "a"->0
    5. overflow -> Integer.Max/Min
     */
    public int myAtoi (String s) {
        // case 1
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int i =0;
        // case 2
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // case 3
        boolean positive = true;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            positive = s.charAt(i) == '+';
            i++;
        }
        // case 4
        long sum = 0;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > (long) Integer.MAX_VALUE + 1) {
                break;
            }
            i++;
        }
        sum = positive ? sum : -sum;
        // case 5
        if (sum > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sum < (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) sum;
    }
}
