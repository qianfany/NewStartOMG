public class L8StringToIntegeratoi {
    /*
    1. null, "" -> 0
    2. "    123" -> 123
    3. "+123" -> 123, "-123" -> -123
    4. "123 1" -> 123, "123a1" -> 123, "a"->0
    5. overflow -> Integer.Max/Min
     */
    public int myAtoi (String str) {
        // case 1
        if (str == null || str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int i =0;
        // case 2
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        // case 3
        boolean positive = true;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            positive = str.charAt(i) == '+';
            i++;
        }
        // case 4
        long sum = 0;
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sum = sum * 10 + (str.charAt(i) - '0');
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
