public class JZ9跳房子1到N级 {
    /*
    Dynamic Programming:

    base case:
    n = 1   f(1) = 1
    n = 2   f(2) = f(2-1) + f(2-2)
    n = 3   f(3) = f(3-1) + f(3-2) + f(3 -3)
            f(n) = f(n-1) + f(n-2) +...+ f(n - (n-1)) + f(n - n)

    f(0) = 0
    f(1) = 1
    f(n) = 2 * f(n -1)
    Time: O(n)
    Space: O(1)
     */
    public int jumpFloor (int target) {
        if (target <= 0) return 0;
        int sum = 1;
        while (target > 1) {
            sum *= 2;
            target--;
        }
        return sum;
    }
}
