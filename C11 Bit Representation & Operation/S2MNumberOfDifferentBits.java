public class S2MNumberOfDifferentBits {
    /*
    use exclusive or
    a ^ b represents the number, for any bits, if the bit is 1, a and b at that bit is different

     */
    public int diffBits (int a, int b) {
        int x = a ^ b;
        int count = 0;
        for (; x != 0; x = x >>> 1) {
            count += (x & 1);
        }
        return count;
    }
}
