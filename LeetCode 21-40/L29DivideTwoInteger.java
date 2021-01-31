public class L29DivideTwoInteger {
    /*
    we're converting the inputs to negative numbers.
    This is because we don't want separate code for all the possible
    combinations of positive/negative divisor and dividend.
    We converted them to negative instead of positive
    because the range of valid negative numbers is bigger,
    and therefore overflows can be cleanly avoided.
    for each step, count how many times the divisor has to be added
    to get the dividend. This is the quotient

    Time: O(n)
    Space: O(1)
     */
    public int divide(int dividend, int divisor) {

        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }


        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        /* Count how many times the divisor has to be added
         * to get the dividend. This is the quotient. */
        int quotient = 0;
        while (dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            quotient = -quotient;
        }
        return quotient;
    }
}
