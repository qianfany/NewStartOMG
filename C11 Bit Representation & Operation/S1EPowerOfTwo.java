public class S1EPowerOfTwo {
    /*
    x is a power of 2 if and only if
    (1) x's binary representation has exactly one bit set
    (2) x > 0
     */
    public boolean isPowerOfTwo (int number) {
        return ((number & (number - 1)) == 0 && number > 0);
    }
}
