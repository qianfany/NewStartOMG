public class JZ31NumberOf1In1ToN {
    /*
    check 1 using mod

     */
    public int number (int n ) {
        int result = 0;
        while (n >= 1) {
            int cur = n;
            while (cur >= 1) {
                if (cur % 10 == 1) {
                    result++;
                }
                cur /= 10;
            }
            n--;
        }
        return result;
    }

    public static void main (String[] args) {
        JZ31NumberOf1In1ToN sol = new JZ31NumberOf1In1ToN();
        System.out.println(sol.number(13));
    }
}
