public class JZ7斐波那契数列 {
    /*
    Dynamic Programming
    base case:
    f[0] = 0    f[1] = 1    f[2] = 2
    induction rule:
    f[i] = f[i - 1] + f[i - 2]

    Time:   O(n)
    Space:  O(n)
     */
    public int Fibonacci (int target) {
        if (target <= 0) {
            return 0;
        }
        int[] fib = new int[target + 2];
        fib[0] = 0; fib[1] = 1; fib[2] = 2;
        for (int i = 3; i <= target; i++) {
            fib[i] = fib[i -1] + fib[i - 2];
        }
        return fib[target];
    }

    /*
    Only store 3 numbers in the memory
    time: O(N)
    Space: O(1)
     */

    public int fibonacciI (int n) {
        if (n <= 0) {
            return 0;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
