public class L50PowerXN {
    /*
     set exponent <= 0 && base == 0     throw new RuntimeException()
     exponent < 0       return 1/ getPower(base, -exponent)
     otherwise getPower (base, -exponent)

    Time : O(log (exponent))
    Extra Space: O(log (exponent))
            2 ^ 200
            |
            2 ^ 100
            |
            2 ^ 50
            |
            2 ^ 25
     */

    public double myPow (double x, int n) {
        if (n == 0 && x != 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (x == 0 && n <= 0) {
            throw new RuntimeException();
        }
        if (x == 0 && n > 0) {
            return 0;
        }

        if (n < 0) {
            return 1 / getPower(x, -n);
        }
        return getPower(x, n);
    }
    private double getPower (double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double half = getPower(base, exponent/2);
        if (exponent % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * base;
        }
    }
}
