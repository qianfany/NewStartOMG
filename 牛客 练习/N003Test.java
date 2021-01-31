import java.util.Arrays;
import java.util.Scanner;

public class N003Test {

    /**
     * 20 - 5
     *  -1
     *  -2
     *  -3
     *  -4
     */
    public int maxNum (int[] array, int target, int total) {
        int remain = total - target;
        if (remain < 0) {
            return 0;
        }
        int res = 1;
        Arrays.sort(array);
        int[] newArray = new int[array.length -1];
        int i = 0;
        while (array[i] != target) {
            newArray[i] = array[i];
            i++;
        }
        i++;
        while (i < array.length) {
            newArray[i-1] = array[i];
            i++;
        }
        int j = 0;
        while (remain >= 0) {
            if (newArray[j] <= remain) {
                res++;
                j++;
            }
            remain = remain - newArray[j];
        }
        return res;
    }

    public static void main (String[] args) {

        int[] array = {1, 4, 8, 3, 5, 5, 6, 2};
        N003Test sol = new N003Test();
        System.out.println((sol.maxNum(array, 5, 20)));
    }
}
//
//        Scanner cin = new Scanner(System.in);
//        String[] s = cin.nextLine().split("");
//        int len = s.length;
//        int[] array = new int[len];
//        for (int i = 0; i < s.length; i++) {
//            array[i] = Integer.parseInt(s[i]);
//        }
//        int target = cin.nextInt();
//        int total = cin.nextInt();