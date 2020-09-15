public class L172FactorialTrailingZeros {
    /**
     *  = 2 * 3 * ... * 5 ... * 10 ... * 15 ... * 25 *...
     *  = 2 * 3 * ... * 5 ... * (5^1 *2) ... (5^1 *3) ... *(5^2 *1)
     *
     *  return n/5 + n/25 + n/625 + n/3125 +...
     * @param n
     * @return
     */
    public int trailingZeros (int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n/5;
            n /= 5;
        }
        return cnt;
    }
}
