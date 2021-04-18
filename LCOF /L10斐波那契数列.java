public class L10斐波那契数列 {

    public int fib (int n) {
        if (n <= 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    public int fib1 (int n) {
        if (n <= 0) {
            return 0;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int third = (first + second) % 1000000007;
            first = second;
            second = third;
        }
        return second;
    }
}
