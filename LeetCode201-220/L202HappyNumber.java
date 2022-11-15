import java.util.HashSet;
import java.util.Set;

public class L202HappyNumber {
    /*
    1. divide
    2. put all value in array
    3. sum everyone

    termination condition
    if the digit occurred in the past, return false
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

}
