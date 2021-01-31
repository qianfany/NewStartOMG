
import java.util.Scanner;

public class N004Test {
    /**
     *  165     172     170     178     175     180
     *  165     170 <-> 172     175 <-> 178     180
     *
     *  180     165     172     175     178     170
     *  165     170     172     175     178     180
     *
     *  selection sort method
     * @param array
     * @return
     */
    public int minSwap (int[] array) {
        int num = 0;
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
            if (i != min) {
                num++;
            }
        }
        return num;
    }

    private void swap (int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main (String[] args) {
        N004Test sol = new N004Test();
        Scanner cin = new Scanner(System.in);
        String[] s = cin.nextLine().split(",");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        System.out.println(sol.minSwap(array));
    }
}

//        int[] array = {165, 172, 170, 178, 175, 180};
//        System.out.println(sol.minSwap(array));
