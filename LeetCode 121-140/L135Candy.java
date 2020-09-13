import java.util.Arrays;

public class L135Candy {
    /**
     *      1       2       3       2       1
     *      1       2       3       1       1
     *      ->
     *      1       2       3       2       1
     *
     * @param ratings
     * @return minimum amount of candies of have
     * Time: O(n)
     * Space: O(n)
     */
    public int candy (int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i-1] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
            }
        }
        int sum = 0;
        for (int r : res) {
            sum += r;
        }
        return sum;
    }

    public static void main (String[] args) {
        L135Candy sol = new L135Candy();
        int[] rating = {1, 2, 3, 2, 1};
        System.out.println(sol.candy(rating));
    }
}
