public class S1EFibonacciNumber {
    /*
    Dynamic Programming
    base case:
    f[0] = 0    f[1] = 1
    induction rule:
    f[i] = f[i- 1] + f[i - 2]

    Time:   O(n)
    Space:  O(n)

     */
    public long fibonacci (int K) {
        if (K <= 0) {
            return 0;
        }
        long[] fib = new long[K + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= K; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[K];
    }

    //Time: O(n)
    // space: O(1)
    public long fibonacciI (int K) {
        if (K <= 0) {
            return 0;
        }
        long first = 0;
        long second = 1;
        for (int i = 2; i <= K; i++) {
            long third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
