public class JZ8跳房子1或2级 {
    /*
    Dynamic Programming
    base case:
    f[0] = 0    f[1] = 1
    induction rule:
    f[i] = f[i - 1] + f[i - 2]

    Time:   O(n)
    Space:  O(n)
     */
    public int jumpFloor (int target ) {
        if (target <= 0) {
            return 0;
        }
        int[] fib = new int[target + 1];
        fib[0] = 0; fib[1] = 1;
        for (int i = 2; i <= target; i++) {
            fib[i] = fib[i -1] + fib[i - 2];
        }
        return fib[target];
    }

    public int JumpFloor (int target) {
        if (target <= 0) {
            return 0;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= target + 1; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
