public class L1GreatestCommonDivisor {
    /*
    greatest common divisor:
    assume num2 <= num1
    Time: O(log(num1))

     */
    public int gcd (int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}
