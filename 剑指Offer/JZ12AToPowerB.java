public class JZ12AToPowerB {
    /*
     case 1:
     set exponent <= 0 && base == 0     throw new RuntimeException()
     case 2:
     exponent < 0       return 1/ getPower(base, -exponent)
     case 3:
     otherwise getPower (base, exponent)

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
    public double power (double base, int exponent) {
        if (exponent == 0 && base != 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (base == 0 && exponent <= 0) {
            throw new RuntimeException();
        }
        if (base == 0 && exponent > 0) {
            return 0;
        }
        if (exponent < 0) {
            return 1 / getPower(base, -exponent);
        }
        return getPower(base, exponent);
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
