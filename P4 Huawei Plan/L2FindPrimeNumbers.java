import java.util.ArrayList;
import java.util.List;

public class L2FindPrimeNumbers {

    public List<Integer> findPrime (int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isPrime (int num) {
        for (int f = 2; f < num; f++) {
            if (isFactor(f, num)) {
                return false;
            }
        }
        return true;
    }

    private boolean isFactor (int factor, int number) {
        return number % factor == 0;
    }

    public static void main (String[] args) {
        L2FindPrimeNumbers sol = new L2FindPrimeNumbers();
        int num = 100;
        System.out.println(sol.findPrime(num));
    }
}
