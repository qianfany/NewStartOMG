public class L190ReverseBits {

    public int reverseBits (int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++, n = n >> 1) {
            if ((n & 1) == 1) ans++;
            if (i != 31) ans *= 2;
        }
        return ans;
    }
}
