public class S2MAtoThePowerOfBLite {

    /*
    Time : O(log b)
    Extra Space: O(log b)
            2 ^ 200
            |
            2 ^ 100
            |
            2 ^ 50
            |
            2 ^ 25
     */
    public long power (int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        long half = power (a, b /2);
        if (b % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * a;
        }
    }
}
