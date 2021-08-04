public class L43整数中出现1的个数 {

    public int countDigitOne (int n) {
        int result = 0;
        while (n >= 1) {
            int cur = n;
            while (cur >= 1) {
                if (cur % 10 == 1) {
                    result ++;
                }
                cur /= 10;
            }
            n--;
        }
        return result;
    }
}
