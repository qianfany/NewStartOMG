import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Main1 {
    public int buyCoke (int m, int a, int b, int c ,int x) {
        int res = 0;
        int cokeLeft = m;
        int m10 = a;
        int m50 = b;
        int m100 = c;
        int cokePrice = x;
        if (m <= 0) {
            return res;
        }
        while (cokeLeft > 0) {
            int priceLeft = cokePrice;
            while (priceLeft > 0) {
                if (m100 > 0) {
                    priceLeft = priceLeft - 100;
                    m100--;
                    res++;
                }
                else if (m50 > 0) {
                    priceLeft = priceLeft - 50;
                    m50--;
                    res++;
                }
                else {
                    priceLeft = priceLeft - 10;
                    m10--;
                    res++;
                }
            }
            priceLeft = priceLeft * -1;
            if (priceLeft >= 50) {
                m50++;
                m10 = (priceLeft - 50) / 10;
            } else {
                m10 = priceLeft / 10;
            }
            cokeLeft--;
        }
        return res;
    }
    public static void main (String[] args) {
        Main1 sol = new Main1();
        System.out.println(sol.buyCoke(2, 1, 4, 3, 250));
    }
}
