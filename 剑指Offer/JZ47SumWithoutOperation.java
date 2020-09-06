public class JZ47SumWithoutOperation {
    /*
    Recursion
    f(n) = f(n-1) + n
    Time: O(n)
    Space: O(n)
     */
    public int sum (int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}
