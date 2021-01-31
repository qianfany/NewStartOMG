import java.util.Arrays;
import java.util.Scanner;

public class N002去重排序 {
    public void sort (int[] array) {
        Arrays.sort(array);
    }

    public int dedup (int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i]) {
                i++;
                array[i] = array[j];
            }
        }
        return i + 1;
    }

    public static void main (String[] args) {
        N002去重排序 sol = new N002去重排序();

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int N = cin.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = cin.nextInt();
            }
            sol.sort(array);
            int index = sol.dedup(array);
            for (int i = 0; i < index; i++) {
                System.out.println(array[i]);
            }
        }
    }

}
//        N002去重排序 sol = new N002去重排序();
//        int[] array1 = {2, 2, 1};
//        int[] array2 = {11, 10, 20, 40, 32, 67, 40, 20, 89, 300, 400, 15};
//        sol.sort(array2);
//        int index = sol.dedup(array2);
//        for (int i = 0; i < index; i++) {
//            System.out.println(array2[i]);
//        }