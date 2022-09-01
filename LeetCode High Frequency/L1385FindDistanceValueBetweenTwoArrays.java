import java.util.Arrays;
import java.util.Collections;

public class L1385FindDistanceValueBetweenTwoArrays {

    /*
    brute force
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    counter++;
                    j = arr2.length;
                }
            }
        }
        return arr1.length - counter;
    }

    public static void main(String[] args) {
        L1385FindDistanceValueBetweenTwoArrays sol = new L1385FindDistanceValueBetweenTwoArrays();
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;
        System.out.println(sol.findTheDistanceValue(arr1, arr2, d));
    }
}
