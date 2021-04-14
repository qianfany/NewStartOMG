public class L263UglyNumber {
    /*
    ugly number
    number whose prime factors only include 2, 3, 5
     */
    public boolean isUgly (int n) {
        int[] primes = {2, 3, 5};

        if (n <= 0) {
            return false;
        }
        for (int factor : primes) {
            while (n % factor == 0) {
                n = n / factor;
            }
        }
        return n == 1;
    }
}
