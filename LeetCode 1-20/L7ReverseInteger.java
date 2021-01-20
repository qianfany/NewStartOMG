public class L7ReverseInteger {
    /*
    x = -123
    -123 % 10 = -3

    tail = -3    newRes = -3          result = -3      x = -12
    tail = -2    newRes = -32         result = -32     x = -1
    tail = -1    newRes = -321        result = -321    x = 0

    Time: O(n)  length(x)
    Space O(1)
     */
    public int reverse (int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newRes = result * 10 + tail;
            // keep mind of overflow
            if ((newRes - tail) /10 != result) {
                return 0;
            }
            result = newRes;
            x = x /10;
        }
        return result;
    }

    public static void main (String[] args) {
        L7ReverseInteger sol = new L7ReverseInteger();
        System.out.println(sol.reverse(-123));
    }
}
